package com.hronline.vm.resume;

import com.hronline.entity.FileUploadManagement;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class CreateResumeVM implements Serializable {
    private String applicantName;

    @Email(message = "Email không hợp lệ")
    private String applicantEmail;

    private String applicantFbLink;

    private String applicantPhone;

    private MultipartFile fileResume;
    private String jobId;
}
