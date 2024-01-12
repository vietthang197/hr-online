package com.hronline.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileUploadManagementDto implements Serializable {
    private String id;

    private String originFileName;

    private Long size;

    private String path;

    private String downloadUrl;

    private String keycloakResourceId;

    private String docCode;

    private String isDeleted;
    private String createdDate;

}
