package com.hronline.services;

import com.hronline.dto.BasicResponseDto;
import com.hronline.dto.JobLocationDto;
import com.hronline.dto.PaginationDto;
import com.hronline.vm.location.CreateJobLocationVM;
import com.hronline.vm.location.JobLocationSearchVM;

public interface JobLocationService {
    void save(CreateJobLocationVM createLocationVM);

    BasicResponseDto<PaginationDto<JobLocationDto>> search(JobLocationSearchVM searchVM);
}
