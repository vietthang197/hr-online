package com.hronline.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "job_info")
@Indexed
@ToString
public class JobInfo extends SuperEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid2")
    @GenericField(sortable = Sortable.YES)
    private String id;

    @Column(length = 200)
    @FullTextField(analyzer = "customAnalyzer")
    private String name;

    @FullTextField(analyzer = "customAnalyzer")
    private String tags;

    @GenericField
    private BigDecimal salaryFrom;
    @GenericField
    private BigDecimal salaryTo;

    private BigDecimal reward;

    @OneToOne
    private JobLocation jobLocation;

    @Lob
    private String description;

    @OneToOne
    private Corporation corporation;

    private Boolean urgent = false;

    private int vacancies;

    @OneToOne
    private FileUploadManagement fileJd;

    @OneToMany(mappedBy = "jobInfo")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<ResumeInfo> resumeInfos;
}
