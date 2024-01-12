package com.hronline.mapper;

import com.hronline.dto.*;
import com.hronline.entity.FileUploadManagement;
import com.hronline.entity.JobInfo;
import com.hronline.util.DateUtils;
import org.mapstruct.Mapper;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface JobInfoMapper {
    default JobInfoDto toDto(JobInfo jobInfo, JobLocationMapper jobLocationMapper, CorporationMapper corporationMapper) {
        FileUploadManagement fileJd = jobInfo.getFileJd();
        return JobInfoDto.builder()
                .id(jobInfo.getId())
                .name(jobInfo.getName())
                .tags(jobInfo.getTags())
                .salaryFrom(jobInfo.getSalaryFrom())
                .salaryTo(jobInfo.getSalaryTo())
                .reward(jobInfo.getReward())
                .jobLocation(jobLocationMapper.toDto(jobInfo.getJobLocation()))
                .description(jobInfo.getDescription())
                .corporation(corporationMapper.toDto(jobInfo.getCorporation()))
                .urgent(jobInfo.getUrgent())
                .createdDate(DateUtils.fromDate(jobInfo.getCreatedDate(), DateUtils.DEFAULT_DATE_FORMAT))
                .vacancies(jobInfo.getVacancies())
                .fileJd(
                        FileUploadManagementDto.builder()
                                .id(fileJd.getId())
                                .originFileName(fileJd.getOriginFileName())
                                .docCode(fileJd.getDocCode())
                                .build()
                )
                .build();
    };
    default List<JobInfoDto> toListDto(List<JobInfo> jobInfos, JobLocationMapper jobLocationMapper, CorporationMapper corporationMapper) {
        return jobInfos.parallelStream().map(jobInfo -> toDto(jobInfo, jobLocationMapper, corporationMapper)).collect(Collectors.toList());
    };
    default PaginationDto<JobInfoDto> toPaginationDto(PaginationDto<JobInfo> jobInfoPaginationDto, JobLocationMapper jobLocationMapper, CorporationMapper corporationMapper) {
        PaginationDto<JobInfoDto> paginationDto = new PaginationDto<>();
        paginationDto.setDraw(jobInfoPaginationDto.getDraw());
        paginationDto.setRecordsFiltered(jobInfoPaginationDto.getRecordsFiltered());
        paginationDto.setRecordsTotal(jobInfoPaginationDto.getRecordsTotal());
        List<JobInfo> jobInfos = jobInfoPaginationDto.getData();
        paginationDto.setData(toListDto(jobInfos, jobLocationMapper, corporationMapper));
        return paginationDto;
    };

}
