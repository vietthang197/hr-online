package com.hronline.mapper;

import com.hronline.dto.IndustryDto;
import com.hronline.dto.JobInfoDto;
import com.hronline.dto.PaginationDto;
import com.hronline.entity.Industry;
import com.hronline.entity.JobInfo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JobInfoMapper {
    JobInfoDto toDto(JobInfo jobInfo);
    List<JobInfoDto> toListDto(List<JobInfo> jobInfos);
    PaginationDto<JobInfoDto> toPaginationDto(PaginationDto<JobInfo> jobInfoPaginationDto);

}
