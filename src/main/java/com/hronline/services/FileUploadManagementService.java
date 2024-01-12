package com.hronline.services;

import com.hronline.dto.FileUploadManagementDto;
import com.hronline.exception.BindingResultException;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileUploadManagementService {
    FileUploadManagementDto saveSingleFile(MultipartFile jdFile) throws IOException;

    FileUploadManagementDto findById(String fileId) throws FileNotFoundException;

    ResponseEntity<Resource> download(String fileId) throws IOException;
}
