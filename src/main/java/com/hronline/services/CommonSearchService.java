package com.hronline.services;

import com.hronline.dto.PaginationDto;
import com.hronline.vm.BaseObjPagination;

import javax.validation.constraints.NotNull;

public interface CommonSearchService<T, I extends BaseObjPagination> {
    PaginationDto<T> searchData(@NotNull I objSearch, Class<T> entityClass);
}
