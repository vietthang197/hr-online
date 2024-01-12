package com.hronline.repository;

import com.hronline.entity.FileUploadManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileUploadManagementRepository extends JpaRepository<FileUploadManagement, String> {
}
