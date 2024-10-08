package com.hronline.vm.job;

import com.hronline.entity.Corporation;
import com.hronline.entity.JobLocation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class CreateJobVM implements Serializable {
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
