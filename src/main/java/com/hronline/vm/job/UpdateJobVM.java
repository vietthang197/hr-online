package com.hronline.vm.job;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateJobVM implements Serializable {
    private String id;
    private String name;

    private String tags;

    private boolean negotiable;
    private BigDecimal salaryFrom;
    private String salaryFromCurrency;
    private String salaryToCurrency;

    private BigDecimal salaryTo;

    private BigDecimal reward;
    private String rewardCurrency;

    private String location;

    private String description;

    private String corporation;
    private String jobType;

    private boolean urgent;
    private MultipartFile fileJd;
    private int vacancies;
}
