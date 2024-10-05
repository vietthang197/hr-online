package com.hronline.services;

import com.hronline.dto.BasicResponseDto;
import com.hronline.dto.JobInfoDto;
import com.hronline.dto.PaginationDto;
import com.hronline.exception.BindingResultException;
import com.hronline.vm.job.CreateJobVM;
import com.hronline.vm.job.JobInfoSearchVM;
import com.hronline.vm.job.UpdateJobVM;

import java.io.IOException;
import java.util.List;

public interface JobService {
    void save(CreateJobVM createJobVM) throws BindingResultException, IOException;

    BasicResponseDto<PaginationDto<JobInfoDto>> search(JobInfoSearchVM searchVM);

    List<JobInfoDto> findLatestJob(int limit);

    JobInfoDto findById(String jobId) throws BindingResultException;

    void update(UpdateJobVM updateJobVM);
}
