package com.hronline.services.impl;

import com.hronline.dto.BasicResponseDto;
import com.hronline.dto.CorporationDto;
import com.hronline.dto.JobInfoDto;
import com.hronline.dto.PaginationDto;
import com.hronline.entity.Corporation;
import com.hronline.entity.JobInfo;
import com.hronline.entity.JobLocation;
import com.hronline.exception.BindingResultException;
import com.hronline.mapper.JobInfoMapper;
import com.hronline.repository.CorporationRepository;
import com.hronline.repository.JobLocationRepository;
import com.hronline.repository.JobRepository;
import com.hronline.services.CommonSearchService;
import com.hronline.services.JobService;
import com.hronline.vm.corp.CorpSearchVM;
import com.hronline.vm.job.CreateJobVM;
import com.hronline.vm.job.JobInfoSearchVM;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final JobLocationRepository locationRepository;
    private final CorporationRepository corporationRepository;
    private final CommonSearchService<JobInfo, JobInfoSearchVM> commonSearchService;
    private final JobInfoMapper jobInfoMapper;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void save(CreateJobVM request) throws BindingResultException {
        Optional<JobLocation> locationOptional = locationRepository.findById(request.getLocation());
        if (locationOptional.isEmpty())
            throw new BindingResultException("Vị trí công việc không hợp lệ");

        Optional<Corporation> corporationOptional = corporationRepository.findById(request.getCorporation());
        if (corporationOptional.isEmpty())
            throw new BindingResultException("Công ty không hợp lệ");

        JobInfo jobInfo = JobInfo.builder()
                .name(request.getName())
                .tags(request.getTags())
                .salaryFrom(request.getSalaryFrom())
                .salaryTo(request.getSalaryTo())
                .reward(request.getReward())
                .jobLocation(locationOptional.get())
                .corporation(corporationOptional.get())
                .description(request.getDescription())
                .urgent(request.isUrgent())
                .build();
        jobRepository.save(jobInfo);
    }

    @Override
    @Transactional
    public BasicResponseDto<PaginationDto<JobInfoDto>> search(JobInfoSearchVM searchVM) {
        PaginationDto<JobInfo> jobInfoPaginationDto = commonSearchService.searchData(searchVM, JobInfo.class);
        PaginationDto<JobInfoDto> response = jobInfoMapper.toPaginationDto(jobInfoPaginationDto);
        return BasicResponseDto.ok(response);
    }
}
