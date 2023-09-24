package com.hronline.services.impl;

import com.hronline.dto.BasicResponseDto;
import com.hronline.dto.JobLocationDto;
import com.hronline.dto.JobTitleDto;
import com.hronline.dto.PaginationDto;
import com.hronline.entity.JobLocation;
import com.hronline.entity.JobTitle;
import com.hronline.exception.BindingResultException;
import com.hronline.mapper.JobLocationMapper;
import com.hronline.mapper.JobTitleMapper;
import com.hronline.repository.JobLocationRepository;
import com.hronline.repository.JobTitleRepository;
import com.hronline.services.CommonSearchService;
import com.hronline.services.JobTitleService;
import com.hronline.vm.DeleteEntityVM;
import com.hronline.vm.jobTitle.CreateJobTitleVM;
import com.hronline.vm.jobTitle.JobTitleSearchVM;
import com.hronline.vm.jobTitle.UpdateJobTitleVM;
import com.hronline.vm.location.JobLocationSearchVM;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class JobTitleServiceImpl implements JobTitleService {

    private final JobTitleRepository jobTitleRepository;
    private final CommonSearchService<JobTitle, JobTitleSearchVM> commonSearchService;
    private final JobTitleMapper jobTitleMapper;

    public JobTitleServiceImpl(JobTitleRepository jobTitleRepository, CommonSearchService<JobTitle, JobTitleSearchVM> commonSearchService, JobTitleMapper jobTitleMapper) {
        this.jobTitleRepository = jobTitleRepository;
        this.commonSearchService = commonSearchService;
        this.jobTitleMapper = jobTitleMapper;
    }

    @Override
    @Transactional
    public BasicResponseDto<PaginationDto<JobTitleDto>> search(JobTitleSearchVM searchVM) {
        PaginationDto<JobTitle> jobTitlePagination = commonSearchService.searchData(searchVM, JobTitle.class);
        PaginationDto<JobTitleDto> response = jobTitleMapper.toPaginationDto(jobTitlePagination);
        return BasicResponseDto.ok(response);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void save(CreateJobTitleVM createJobTitleVM) {
        JobTitle jobTitle = JobTitle.builder()
                .name(createJobTitleVM.getName())
                .build();
        jobTitleRepository.save(jobTitle);
    }

    @Override
    @Transactional
    public Optional<JobTitle> findById(String id) {
        return jobTitleRepository.findById(id);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void update(UpdateJobTitleVM updateJobTitleVM) throws BindingResultException {
        Optional<JobTitle> jobTitleOptional = jobTitleRepository.findById(updateJobTitleVM.getId());
        if (jobTitleOptional.isEmpty()) {
            throw new BindingResultException("Id chức vụ không tồn tại");
        }
        JobTitle jobTitle = jobTitleOptional.get();
        jobTitle.setName(updateJobTitleVM.getName());
        jobTitleRepository.save(jobTitle);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public BasicResponseDto<Void> delete(DeleteEntityVM deleteEntityVM) {
        jobTitleRepository.deleteAllById(deleteEntityVM.getIds());
        return BasicResponseDto.ok();
    }
}
