package com.hronline.vm.corp;

import com.hronline.annotation.SearchColumn;
import com.hronline.obj.DataType;
import com.hronline.obj.SearchType;
import com.hronline.vm.BaseObjPagination;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
public class CorpSearchVM extends BaseObjPagination implements Serializable {
    @SearchColumn(columnName = "id", searchType = SearchType.MATCH, dataType = DataType.STRING)
    private String id;
    @SearchColumn(columnName = "name", searchType = SearchType.MATCH, dataType = DataType.STRING)
    private String name;
}
