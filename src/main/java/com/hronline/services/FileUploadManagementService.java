package com.hronline.services;

import com.hronline.dto.FileUploadManagementDto;
import com.hronline.exception.BindingResultException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileUploadManagementService {
    FileUploadManagementDto saveSingleFile(MultipartFile jdFile) throws IOException;

    FileUploadManagementDto findById(String fileId) throws FileNotFoundException;

    void download(String fileId, HttpServletResponse httpServletResponse) throws IOException;
}
