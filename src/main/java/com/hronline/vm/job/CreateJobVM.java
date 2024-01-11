package com.hronline.vm.job;

import com.hronline.entity.Corporation;
import com.hronline.entity.JobLocation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class CreateJobVM implements Serializable {
    private String name;

    private String tags;

    private BigDecimal salaryFrom;

    private BigDecimal salaryTo;

    private BigDecimal reward;

    private JobLocation jobLocation;

    private String description;

    private String corporation;

    private boolean urgent;
}
