package com.hronline.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "industry")
@Indexed
@ToString
public class Industry extends SuperEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid2")
    @GenericField(sortable = Sortable.YES)
    private String id;

    // Tên ngành nghề của công ty
    @Column(length = 100)
    @FullTextField(analyzer = "customAnalyzer")
    private String name;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "corporation_industries", joinColumns = {
            @JoinColumn(name = "corp_id", referencedColumnName = "id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "industry_id", referencedColumnName = "id")
    })
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<Corporation> corporations = new HashSet<>();
}
