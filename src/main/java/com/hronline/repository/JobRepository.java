package com.hronline.repository;

import com.hronline.entity.JobInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<JobInfo, String>, PagingAndSortingRepository<JobInfo, String> {
    @EntityGraph("jobInfoCorpFileResumeLocation")
    Page<JobInfo> findAll(Pageable pageRequest);

    @EntityGraph("jobInfoCorpFileResumeLocation")
    Optional<JobInfo> findById(String id);
}
