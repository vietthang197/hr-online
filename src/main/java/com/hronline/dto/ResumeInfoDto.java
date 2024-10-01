package com.hronline.dto;

import com.hronline.entity.FileUploadManagement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;

import javax.persistence.OneToOne;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResumeInfoDto implements Serializable {
    private String id;
    private String applicantName;
    private String applicantEmail;
    private String applicantFbLink;
    private String applicantPhone;
    private FileUploadManagementDto fileResume;
    private JobInfoDto jobInfo;
    private String createdDate;
}
