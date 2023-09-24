package com.hronline.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "corporation")
@Indexed
@ToString
public class Corporation extends SuperEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid2")
    @GenericField(sortable = Sortable.YES)
    private String id;

    @Column(length = 200)
    @FullTextField(analyzer = "customAnalyzer")
    private String name;

    // ngành nghề công ty
    @Column(length = 200)
    private String industry;

    // Địa chỉ công ty
    @Column(length = 500)
    @FullTextField(analyzer = "customAnalyzer")
    private String address;

    // Số điện thoại đại diện
    @Column(length = 11)
    @FullTextField(analyzer = "customAnalyzer")
    private String phone;

    // mã số thuế
    @Column(length = 200)
    @FullTextField(analyzer = "customAnalyzer")
    private String taxId;

    // website công ty
    @Column(length = 500)
    @FullTextField(analyzer = "customAnalyzer")
    private String website;

    // Giới thiệu công ty
    @Column(length = 1500)
    @FullTextField(analyzer = "customAnalyzer")
    private String description;
}
