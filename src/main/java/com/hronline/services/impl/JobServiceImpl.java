package com.hronline.services.impl;

import com.hronline.dto.*;
import com.hronline.entity.Corporation;
import com.hronline.entity.FileUploadManagement;
import com.hronline.entity.JobInfo;
import com.hronline.entity.JobLocation;
import com.hronline.exception.BindingResultException;
import com.hronline.mapper.CorporationMapper;
import com.hronline.mapper.JobInfoMapper;
import com.hronline.mapper.JobLocationMapper;
import com.hronline.repository.CorporationRepository;
import com.hronline.repository.FileUploadManagementRepository;
import com.hronline.repository.JobLocationRepository;
import com.hronline.repository.JobRepository;
import com.hronline.services.CommonSearchService;
import com.hronline.services.FileUploadManagementService;
import com.hronline.services.JobService;
import com.hronline.util.HrConstant;
import com.hronline.vm.corp.CorpSearchVM;
import com.hronline.vm.job.CreateJobVM;
import com.hronline.vm.job.JobInfoSearchVM;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final JobLocationRepository locationRepository;
    private final CorporationRepository corporationRepository;
    private final CommonSearchService<JobInfo, JobInfoSearchVM> commonSearchService;
    private final JobInfoMapper jobInfoMapper;
    private final JobLocationMapper jobLocationMapper;
    private final CorporationMapper corporationMapper;
    private final FileUploadManagementService fileUploadManagementService;
    private final FileUploadManagementRepository fileUploadManagementRepository;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void save(CreateJobVM request) throws BindingResultException, IOException {
        Optional<JobLocation> locationOptional = locationRepository.findById(request.getLocation());
        if (locationOptional.isEmpty())
            throw new BindingResultException("Vị trí công việc không hợp lệ");

        Optional<Corporation> corporationOptional = corporationRepository.findById(request.getCorporation());
        if (corporationOptional.isEmpty())
            throw new BindingResultException("Công ty không hợp lệ");

        FileUploadManagementDto fileJd = fileUploadManagementService.saveSingleFile(request.getFileJd());
        FileUploadManagement fileUploadManagement = FileUploadManagement.builder()
                .docCode(HrConstant.JD_CODE)
                .path(fileJd.getPath())
                .size(fileJd.getSize())
                .originFileName(fileJd.getOriginFileName())
                .isDeleted(HrConstant.STR_N)
                .build();

        fileUploadManagement = fileUploadManagementRepository.save(fileUploadManagement);

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
                .vacancies(request.getVacancies())
                .fileJd(fileUploadManagement)
                .build();

        jobRepository.save(jobInfo);
    }

    @Override
    @Transactional
    public BasicResponseDto<PaginationDto<JobInfoDto>> search(JobInfoSearchVM searchVM) {
        PaginationDto<JobInfo> jobInfoPaginationDto = commonSearchService.searchData(searchVM, JobInfo.class);
        PaginationDto<JobInfoDto> response = jobInfoMapper.toPaginationDto(jobInfoPaginationDto, jobLocationMapper, corporationMapper);
        return BasicResponseDto.ok(response);
    }

    @Override
    @Transactional
    public List<JobInfoDto> findLatestJob(int limit) {
        PageRequest pageRequest = PageRequest.of(0, 6, Sort.by("createdDate").descending());
        List<JobInfo> jobInfos = jobRepository.findAll(pageRequest).get().collect(Collectors.toList());
        return jobInfoMapper.toListDto(jobInfos, jobLocationMapper, corporationMapper);
    }

    @Override
    @Transactional
    public JobInfoDto findById(String jobId) throws BindingResultException {
        Optional<JobInfo> jobInfoOptional = jobRepository.findById(jobId);
        if (jobInfoOptional.isEmpty())
            throw new BindingResultException("Job khong ton tai");
        return jobInfoMapper.toDto(jobInfoOptional.get(), jobLocationMapper, corporationMapper);
    }
}
