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
import java.time.LocalDateTime;
import java.util.Date;
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
@NamedEntityGraph(name = "jobInfoCorpFileResumeLocation", attributeNodes = {
        @NamedAttributeNode("jobLocation"),
        @NamedAttributeNode(value = "corporation", subgraph = "corp.industries"),
        @NamedAttributeNode("fileJd"),
        @NamedAttributeNode("resumeInfos")
}, subgraphs = {
        @NamedSubgraph(name = "corp.industries", attributeNodes = @NamedAttributeNode("industries"))
})
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

    private String jobType;

    private Boolean negotiable; // luong thoa thuan hay khong

    @GenericField
    private BigDecimal salaryFrom;

    private String salaryFromCurrency;

    @GenericField
    private BigDecimal salaryTo;

    private String salaryToCurrency;

    private BigDecimal reward;

    private String rewardCurrency;

    @OneToOne
    private JobLocation jobLocation;

    @Lob
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "corporation_id", referencedColumnName = "id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    @IndexedEmbedded
    private Corporation corporation;

    private Boolean urgent = false;

    private int vacancies;

    @OneToOne
    @JoinColumn(name = "file_jd_id", referencedColumnName = "id")
    private FileUploadManagement fileJd;

    @OneToMany(mappedBy = "jobInfo")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<ResumeInfo> resumeInfos;

    private LocalDateTime expiredDate; // ngay het han

    private Boolean enabled;
}
