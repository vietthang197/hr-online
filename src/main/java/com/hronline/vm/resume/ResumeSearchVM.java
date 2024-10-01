package com.hronline.vm.resume;

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
public class ResumeSearchVM extends BaseObjPagination implements Serializable {
    @SearchColumn(columnName = "id", searchType = SearchType.MATCH, dataType = DataType.STRING)
    private String id;

    @SearchColumn(columnName = "applicantPhone", searchType = SearchType.MATCH, dataType = DataType.STRING)
    private String applicantPhone;

    @SearchColumn(columnName = "applicantEmail", searchType = SearchType.MATCH, dataType = DataType.STRING)
    private String applicationEmail;

    @SearchColumn(columnName = "jobInfo.id", searchType = SearchType.MATCH, dataType = DataType.STRING)
    private String jobId;
}
