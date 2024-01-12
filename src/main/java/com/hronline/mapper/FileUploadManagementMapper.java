package com.hronline.mapper;

import com.hronline.dto.FileUploadManagementDto;
import com.hronline.entity.FileUploadManagement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileUploadManagementMapper {
    FileUploadManagementDto toDto(FileUploadManagement fileUploadManagement);
}
