package com.hronline.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "corporation")
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

    private String description;

    @OneToOne
    private Corporation corporation;

    private Boolean urgent = false;
}
