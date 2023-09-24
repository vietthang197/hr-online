package com.hronline.services;

import com.hronline.dto.BasicResponseDto;
import com.hronline.dto.JobLocationDto;
import com.hronline.dto.JobTitleDto;
import com.hronline.dto.PaginationDto;
import com.hronline.entity.JobTitle;
import com.hronline.exception.BindingResultException;
import com.hronline.vm.DeleteEntityVM;
import com.hronline.vm.jobTitle.CreateJobTitleVM;
import com.hronline.vm.jobTitle.JobTitleSearchVM;
import com.hronline.vm.jobTitle.UpdateJobTitleVM;

import java.util.Optional;

public interface JobTitleService {
    BasicResponseDto<PaginationDto<JobTitleDto>> search(JobTitleSearchVM searchVM);

    void save(CreateJobTitleVM createJobTitleVM);

    Optional<JobTitle> findById(String id);

    void update(UpdateJobTitleVM updateJobTitleVM) throws BindingResultException;

    BasicResponseDto<Void> delete(DeleteEntityVM deleteEntityVM);
}
