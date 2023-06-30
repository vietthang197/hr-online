package com.hronline.vm;

import com.hronline.annotation.SearchColumn;
import com.hronline.obj.DataType;
import com.hronline.obj.SearchType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
public class CorpIndustrySearchVM extends BaseObjPagination implements Serializable {
    @SearchColumn(columnName = "id", searchType = SearchType.MATCH, dataType = DataType.STRING)
    private String id;
    @SearchColumn(columnName = "name", searchType = SearchType.MATCH, dataType = DataType.STRING)
    private String name;
}
