package com.hronline.services.impl;

import com.hronline.annotation.SearchColumn;
import com.hronline.dto.PaginationDto;
import com.hronline.exception.SearchEngineException;
import com.hronline.obj.ColumnMetaData;
import com.hronline.obj.DataType;
import com.hronline.obj.Position;
import com.hronline.obj.SearchType;
import com.hronline.services.CommonSearchService;
import com.hronline.util.HrUtils;
import com.hronline.vm.BaseObjPagination;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Strings;
import org.hibernate.search.engine.search.query.dsl.SearchQueryFinalStep;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

@Repository
@Transactional(
        readOnly = true
)
public class CommonSearchServiceImpl<T, I extends BaseObjPagination> implements CommonSearchService<T, I> {
    private final Logger logger = LogManager.getLogger();
    private final EntityManager entityManager;

    public CommonSearchServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public PaginationDto<T> searchData(I objSearch, Class<T> entityClass) {
        PaginationDto<T> paginationDto = new PaginationDto<>();
        paginationDto.setPage(objSearch.getPage());
        paginationDto.setSize(objSearch.getSize());
        try {
            logger.info("==========Searching object {}==========", objSearch.getClass().getName());
            // convert object search sang ColumnMetaData
            // hỗ trợ 3 loại search là search contain, equals và range
            Field[] fields = objSearch.getClass().getDeclaredFields();
            Map<String, ColumnMetaData> metaDataMap = new WeakHashMap<>();
            for (Field field : fields) {
                ColumnMetaData meta = new ColumnMetaData();
                SearchColumn searchColumn = field.getDeclaredAnnotation(SearchColumn.class);
                if (searchColumn != null) {
                    if (Strings.isEmpty(searchColumn.columnName()))
                        meta.setName(field.getName());
                    else
                        meta.setName(searchColumn.columnName());

                    meta.setDataType(searchColumn.dataType());
                    meta.setSearchType(searchColumn.searchType());
                    field.setAccessible(true);
                    Object fieldValue = field.get(objSearch);
                    String valueSearch = fieldValue == null ? null : String.valueOf(fieldValue);
                    if (meta.getSearchType() == SearchType.MATCH) {
                        meta.setValueSearch(HrUtils.getValueOfDataType(valueSearch, searchColumn.dataType(), searchColumn.format()));
                    } else {
                        if (searchColumn.position() == Position.LOWER)
                            meta.setLowerBound(HrUtils.getValueOfDataType(valueSearch, searchColumn.dataType(), searchColumn.format()));
                        else
                            meta.setUpperBound(HrUtils.getValueOfDataType(valueSearch, searchColumn.dataType(), searchColumn.format()));
                    }
                    field.setAccessible(false);
                    ColumnMetaData existsData = metaDataMap.get(meta.getName());
                    if (existsData == null) {
                        metaDataMap.put(meta.getName(), meta);
                    } else {
                        if (existsData.getSearchType() != SearchType.RANGE)
                            throw new SearchEngineException("Duplicate column name " + existsData.getName() + " with search type match");
                        if (searchColumn.position() == Position.LOWER) {
                            existsData.setLowerBound(meta.getLowerBound());
                        } else {
                            existsData.setUpperBound(meta.getUpperBound());
                        }
                    }
                } else {
                    meta.setName(field.getName());
                    meta.setDataType(DataType.STRING);
                    field.setAccessible(true);
                    meta.setSearchType(SearchType.MATCH);
                    meta.setValueSearch(field.get(objSearch));
                    field.setAccessible(false);
                    metaDataMap.put(meta.getName(), meta);
                }
            }
            logger.info("ObjectSearchMetaData: {}", metaDataMap);
            SearchSession searchSession = Search.session(entityManager);
            SearchQueryFinalStep<T> queryFinalStep = searchSession.search(entityClass).where(f -> f.bool(b -> {
                b.must(f.matchAll());
                for (Map.Entry<String, ColumnMetaData> column : metaDataMap.entrySet()) {
                    ColumnMetaData columMeta = column.getValue();
                    if (columMeta.getSearchType() == SearchType.MATCH && columMeta.getValueSearch() != null) {
                        logger.info("Search match column: {}, value: {}", columMeta.getName(), columMeta.getValueSearch());
                        b.must(f.match().field(columMeta.getName()).matching(columMeta.getValueSearch()));
                    } else if (columMeta.getSearchType() == SearchType.RANGE && (columMeta.getLowerBound() != null || columMeta.getUpperBound() != null)) {
                        if (columMeta.getLowerBound() != null && columMeta.getUpperBound() != null) {
                            logger.info("Search range column: {}, fromValue: {}, toValue: {}", columMeta.getName(), columMeta.getLowerBound(), columMeta.getUpperBound());
                            b.must(f.range().field(columMeta.getName()).between(columMeta.getLowerBound(), columMeta.getUpperBound()));
                        } else if (columMeta.getLowerBound() != null) {
                            logger.info("Search greater than column: {}, fromValue: {}", columMeta.getName(), columMeta.getLowerBound());
                            b.must(f.range().field(columMeta.getName()).greaterThan(columMeta.getLowerBound()));
                        } else {
                            logger.info("Search less than column: {}, fromValue: {}", columMeta.getName(), columMeta.getLowerBound());
                            b.must(f.range().field(columMeta.getName()).lessThan(columMeta.getUpperBound()));
                        }
                    }
                }
            }));
            paginationDto.setTotal(queryFinalStep.fetchTotalHitCount());
            paginationDto.setData(queryFinalStep.fetchHits(objSearch.getPage() * objSearch.getSize(), objSearch.getSize()));
            logger.info("Data searching: {}", paginationDto);
            return paginationDto;
        } catch (Exception e) {
            logger.error("Lỗi search engine", e);
            paginationDto.setTotal(0L);
            paginationDto.setSize(0);
            paginationDto.setData(Collections.emptyList());
        } finally {
            logger.info("============= End Searching===========");
        }
        return paginationDto;
    }
}
