package com.hronline.repository;

import com.hronline.entity.CorpIndustry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorpIndustryRepository extends JpaRepository<CorpIndustry, String> {
}
