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
@Table(name = "file_upload_config")
@Indexed
@ToString
public class FileUploadConfig extends SuperEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid2")
    @GenericField(sortable = Sortable.YES)
    private String id;

    @Column(length = 20)
    @FullTextField(analyzer = "customAnalyzer")
    private String ext;

    @Column(length = 200)
    @FullTextField(analyzer = "customAnalyzer")
    private String name;

    @GenericField
    private Long minSize;

    @GenericField
    private Long maxSize;
}
