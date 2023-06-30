package com.hronline.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author thanglv on 08/04/2022
 * @project recruiter-api
 */
@Data
@ToString
public class PaginationDto<T> implements Serializable {
    private int page;
    private int size;
    private long total;
    private List<T> data;
}
