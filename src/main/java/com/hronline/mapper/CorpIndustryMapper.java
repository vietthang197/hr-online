package com.hronline.mapper;

import com.hronline.dto.CorpIndustryDto;
import com.hronline.dto.PaginationDto;
import com.hronline.entity.CorpIndustry;
import com.hronline.util.DateUtils;
import org.mapstruct.Mapper;
import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CorpIndustryMapper {

    default CorpIndustryDto toDto(CorpIndustry corpIndustry) {
        if ( corpIndustry == null ) {
            return null;
        }

        CorpIndustryDto.CorpIndustryDtoBuilder corpIndustryDto = CorpIndustryDto.builder();

        corpIndustryDto.id( corpIndustry.getId() );
        corpIndustryDto.name( corpIndustry.getName() );
        corpIndustryDto.createdBy( corpIndustry.getCreatedBy() );
        if ( corpIndustry.getCreatedDate() != null ) {
            corpIndustryDto.createdDate(DateUtils.fromDate(corpIndustry.getCreatedDate(), DateUtils.DEFAULT_DATE_FORMAT));
        }

        return corpIndustryDto.build();
    }

    default PaginationDto<CorpIndustryDto> toPaginationDto(PaginationDto<CorpIndustry> industryPagination) {
        if ( industryPagination == null ) {
            return null;
        }

        PaginationDto<CorpIndustryDto> paginationDto = new PaginationDto<CorpIndustryDto>();

        paginationDto.setPage( industryPagination.getPage() );
        paginationDto.setSize( industryPagination.getSize() );
        paginationDto.setTotal( industryPagination.getTotal() );
        paginationDto.setData( corpIndustryListToCorpIndustryDtoList( industryPagination.getData() ) );

        return paginationDto;
    }

    default List<CorpIndustryDto> corpIndustryListToCorpIndustryDtoList(List<CorpIndustry> list) {
        if ( list == null ) {
            return null;
        }

        List<CorpIndustryDto> list1 = new ArrayList<CorpIndustryDto>( list.size() );
        for ( CorpIndustry corpIndustry : list ) {
            list1.add( toDto( corpIndustry ) );
        }

        return list1;
    }
}
