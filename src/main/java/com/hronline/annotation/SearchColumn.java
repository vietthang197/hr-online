package com.hronline.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.hronline.obj.DataType;
import com.hronline.obj.SearchType;
import com.hronline.obj.Position;

/**
 * @author thanglv on 08/04/2022
 * @project recruiter-api
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SearchColumn {
    String columnName() default "";

    DataType dataType() default DataType.STRING;

    SearchType searchType() default SearchType.MATCH;

    Position position() default Position.LOWER;

    String format() default "";
}
