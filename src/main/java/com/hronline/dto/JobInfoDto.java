package com.hronline.dto;

import com.hronline.entity.Corporation;
import com.hronline.entity.JobLocation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobInfoDto implements Serializable {
    private String id;
    private String name;
    private String tags;
    private String jobType;
    private Boolean negotiable;
    private BigDecimal salaryFrom;
    private String salaryFromCurrency;
    private BigDecimal salaryTo;
    private String salaryToCurrency;
    private BigDecimal reward;
    private String rewardCurrency;
    private JobLocationDto jobLocation;
    private String description;
    private CorporationDto corporation;
    private boolean urgent;
    private String createdDate;
    // số lượng tuyển
    private int vacancies;
    private FileUploadManagementDto fileJd;

    private String expiredDate;
    private Boolean enabled;
}
