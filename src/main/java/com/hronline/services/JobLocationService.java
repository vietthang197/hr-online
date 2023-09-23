package com.hronline.services;

import com.hronline.dto.BasicResponseDto;
import com.hronline.dto.JobLocationDto;
import com.hronline.dto.PaginationDto;
import com.hronline.entity.JobLocation;
import com.hronline.exception.BindingResultException;
import com.hronline.vm.DeleteEntityVM;
import com.hronline.vm.location.CreateJobLocationVM;
import com.hronline.vm.location.JobLocationSearchVM;
import com.hronline.vm.location.UpdateJobLocationVM;

import java.util.Optional;

public interface JobLocationService {
    void save(CreateJobLocationVM createLocationVM);

    BasicResponseDto<PaginationDto<JobLocationDto>> search(JobLocationSearchVM searchVM);

    Optional<JobLocation> findById(String id);

    void update(UpdateJobLocationVM updateJobLocationVM) throws BindingResultException;

    BasicResponseDto<Void> delete(DeleteEntityVM deleteEntityVM);
}
