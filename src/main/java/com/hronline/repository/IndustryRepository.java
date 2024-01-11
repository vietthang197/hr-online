package com.hronline.repository;

import com.hronline.entity.Industry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface IndustryRepository extends JpaRepository<Industry, String> {
    Set<Industry> findAllByIdIn(Collection<String> ids);
}
