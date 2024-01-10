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
@Table(name = "file_upload_management")
@Indexed
@ToString
public class FileUploadManagement extends SuperEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid2")
    @GenericField(sortable = Sortable.YES)
    private String id;

    // tên file gốc ban đầu
    @Column(length = 500)
    @FullTextField(analyzer = "customAnalyzer")
    private String originFileName;

    private Long size;

    @Column(length = 1000)
    private String path;

    private String downloadUrl;

    @Column(length = 500)
    @FullTextField(analyzer = "customAnalyzer")
    private String keycloakResourceId;

    @Column(length = 100)
    @FullTextField(analyzer = "customAnalyzer")
    private String docCode;

    @Column(length = 2)
    private String isDeleted;
}
