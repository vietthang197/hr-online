package com.hronline.services.impl;

import com.hronline.dto.BasicResponseDto;
import com.hronline.dto.JobLocationDto;
import com.hronline.dto.PaginationDto;
import com.hronline.entity.JobLocation;
import com.hronline.exception.BindingResultException;
import com.hronline.mapper.JobLocationMapper;
import com.hronline.repository.JobLocationRepository;
import com.hronline.services.CommonSearchService;
import com.hronline.services.JobLocationService;
import com.hronline.vm.DeleteEntityVM;
import com.hronline.vm.location.CreateJobLocationVM;
import com.hronline.vm.location.JobLocationSearchVM;
import com.hronline.vm.location.UpdateJobLocationVM;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class JobLocationServiceImpl implements JobLocationService {

    private final JobLocationRepository jobLocationRepository;
    private final CommonSearchService<JobLocation, JobLocationSearchVM> commonSearchService;
    private final JobLocationMapper jobLocationMapper;

    public JobLocationServiceImpl(JobLocationRepository jobLocationRepository,
                                  CommonSearchService<JobLocation, JobLocationSearchVM> commonSearchService,
                                  JobLocationMapper jobLocationMapper) {
        this.jobLocationRepository = jobLocationRepository;
        this.commonSearchService = commonSearchService;
        this.jobLocationMapper = jobLocationMapper;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void save(CreateJobLocationVM createJobLocationVM) {
        JobLocation jobLocation = JobLocation.builder()
                .name(createJobLocationVM.getName())
                .build();
        jobLocationRepository.save(jobLocation);
    }

    @Override
    @Transactional
    public BasicResponseDto<PaginationDto<JobLocationDto>> search(JobLocationSearchVM searchVM) {
        PaginationDto<JobLocation> jobLocationPagination = commonSearchService.searchData(searchVM, JobLocation.class);
        PaginationDto<JobLocationDto> response = jobLocationMapper.toPaginationDto(jobLocationPagination);
        return BasicResponseDto.ok(response);
    }

    @Override
    public Optional<JobLocation> findById(String id) {
        return jobLocationRepository.findById(id);
    }

    @Override
    public void update(UpdateJobLocationVM updateJobLocationVM) throws BindingResultException {
        Optional<JobLocation> corpIndustryOptional = jobLocationRepository.findById(updateJobLocationVM.getId());
        if (corpIndustryOptional.isEmpty()) {
            throw new BindingResultException("Id địa chỉ làm việc không tồn tại");
        }
        JobLocation jobLocation = corpIndustryOptional.get();
        jobLocation.setName(updateJobLocationVM.getName());
        jobLocationRepository.save(jobLocation);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public BasicResponseDto<Void> delete(DeleteEntityVM deleteEntityVM) {
        jobLocationRepository.deleteAllById(deleteEntityVM.getIds());
        return BasicResponseDto.ok();
    }

    @Override
    @Transactional
    public List<JobLocationDto> findAll() {
        return jobLocationMapper.toListDto(jobLocationRepository.findAll());
    }
}
