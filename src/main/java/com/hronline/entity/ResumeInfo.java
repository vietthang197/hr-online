package com.hronline.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "resume_info")
@Indexed
@ToString
public class ResumeInfo extends SuperEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid2")
    @GenericField(sortable = Sortable.YES)
    private String id;

    @FullTextField(analyzer = "customAnalyzer")
    private String applicantName;

    @FullTextField(analyzer = "customAnalyzer")
    private String applicantEmail;

    @FullTextField(analyzer = "customAnalyzer")
    private String applicantFbLink;

    @FullTextField(analyzer = "customAnalyzer")
    private String applicantPhone;

    @OneToOne
    private FileUploadManagement fileResume;

    @IndexedEmbedded
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private JobInfo jobInfo;

    private String resumeStatus; // chua xu ly, dang cho cong ty phan hoi, bi cong ty tu choi, bi hr tu choi, duoc cong ty chap nhan

    private String isDeleted; // bi xoa
}
