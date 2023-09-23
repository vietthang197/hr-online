package com.hronline.repository;

import com.hronline.entity.JobLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobLocationRepository extends JpaRepository<JobLocation, String> {
}
