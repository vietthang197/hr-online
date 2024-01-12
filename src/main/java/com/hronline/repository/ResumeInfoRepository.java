package com.hronline.repository;

import com.hronline.entity.ResumeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeInfoRepository extends JpaRepository<ResumeInfo, String> {
}
