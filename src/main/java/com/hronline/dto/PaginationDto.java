package com.hronline.dto;

import lombok.Data;

import java.util.List;

/**
 * @author thanglv on 08/04/2022
 * @project recruiter-api
 */
@Data
public class PaginationDto<T> {
    private int page;
    private int size;
    private long total;
    private List<T> data;
}
