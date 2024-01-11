package com.hronline.services;

import com.hronline.dto.BasicResponseDto;
import com.hronline.dto.JobInfoDto;
import com.hronline.dto.PaginationDto;
import com.hronline.exception.BindingResultException;
import com.hronline.vm.job.CreateJobVM;
import com.hronline.vm.job.JobInfoSearchVM;

public interface JobService {
    void save(CreateJobVM createJobVM) throws BindingResultException;

    BasicResponseDto<PaginationDto<JobInfoDto>> search(JobInfoSearchVM searchVM);
}
