package com.hronline.obj;

import lombok.Data;
import lombok.ToString;

/**
 * @author thanglv on 4/10/2022
 * @project recruiter-api
 */
@Data
@ToString
public class ColumnMetaData {
    private String name;
    private DataType dataType;
    private SearchType searchType;
    private Object valueSearch;
    private Object lowerBound;
    private Object upperBound;
    private Position position;
}
