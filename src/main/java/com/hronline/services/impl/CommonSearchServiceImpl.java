package com.hronline.services.impl;

import com.hronline.services.CommonSearchService;
import com.hronline.vm.BaseObjPagination;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional(
        readOnly = true
)
public class CommonSearchServiceImpl<T, I extends BaseObjPagination> implements CommonSearchService<T, I> {
    private final EntityManager entityManager;

    public CommonSearchServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
