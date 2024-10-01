package com.hronline.config;

import com.hronline.entity.*;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 * @author thanglv on 26/03/2022
 * @project recruiter-api
 */
@Component
public class SearchEngineConfiguration implements CommandLineRunner {
    private final EntityManager entityManager;

    public SearchEngineConfiguration(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        SearchSession searchSession = Search.session(entityManager);
        searchSession.massIndexer(Corporation.class, FileUploadConfig.class, FileUploadManagement.class, Industry.class, JobInfo.class, JobLocation.class, JobTitle.class, ResumeInfo.class).startAndWait();
    }
}

