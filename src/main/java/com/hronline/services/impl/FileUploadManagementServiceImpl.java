package com.hronline.services.impl;

import com.hronline.dto.FileUploadManagementDto;
import com.hronline.entity.FileUploadManagement;
import com.hronline.exception.BindingResultException;
import com.hronline.mapper.FileUploadManagementMapper;
import com.hronline.repository.FileUploadManagementRepository;
import com.hronline.services.FileUploadManagementService;
import com.hronline.util.HrConstant;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileSystem;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileUploadManagementServiceImpl implements FileUploadManagementService {

    public static final String dataDir = "file_upload";
    private final FileUploadManagementRepository fileUploadManagementRepository;
    private final FileUploadManagementMapper fileUploadManagementMapper;

    @Override
    public FileUploadManagementDto saveSingleFile(MultipartFile jdFile) throws IOException {
        FileUploadManagementDto fileUpload = FileUploadManagementDto.builder()
                .originFileName(jdFile.getOriginalFilename())
                .size(jdFile.getSize())
                .isDeleted(HrConstant.STR_N)
                .build();

        Path dataPath = Paths.get(dataDir);
        if (!(Files.exists(dataPath) && Files.isDirectory(dataPath))) {
            Files.createDirectories(dataPath);
        }

        String newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(jdFile.getOriginalFilename());
        String newFilePath = dataPath + File.pathSeparator + newFileName;
        try (OutputStream os = new FileOutputStream(new File(newFilePath));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(os);) {
            bufferedOutputStream.write(jdFile.getBytes());
        }

        fileUpload.setPath(newFilePath);
        return fileUpload;
    }

    @Override
    @Transactional
    public FileUploadManagementDto findById(String fileId) throws FileNotFoundException {
        Optional<FileUploadManagement> fileUploadManagementOptional = fileUploadManagementRepository.findById(fileId);
        if (fileUploadManagementOptional.isEmpty())
            throw new FileNotFoundException("Không tìm thấy file");
        return fileUploadManagementMapper.toDto(fileUploadManagementOptional.get());
    }

    @Override
    @Transactional
    public void download(String fileId, HttpServletResponse httpServletResponse) throws IOException {
        FileUploadManagementDto fileUploadManagementDto = findById(fileId);
        Path filePath = Paths.get(fileUploadManagementDto.getPath());
        if (Files.notExists(filePath))
            throw new FileNotFoundException("Không tìm thấy file");

        httpServletResponse.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE);
        httpServletResponse.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileUploadManagementDto.getOriginFileName() + "\"");
        OutputStream os = httpServletResponse.getOutputStream();
        os.write(Files.readAllBytes(filePath));

    }
}
