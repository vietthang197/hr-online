package com.hronline.controller;

import com.hronline.dto.FileUploadManagementDto;
import com.hronline.services.FileUploadManagementService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {

    private final FileUploadManagementService fileUploadManagementService;

    @GetMapping("/download/{fileId}")
    public void downloadFile(@PathVariable @Valid @NotBlank String fileId, HttpServletResponse httpServletResponse) throws IOException {
        fileUploadManagementService.download(fileId, httpServletResponse);
    }
}
