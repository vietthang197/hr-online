package com.hronline.mapper;

import com.hronline.dto.CorpIndustryDto;
import com.hronline.dto.JobLocationDto;
import com.hronline.dto.PaginationDto;
import com.hronline.entity.CorpIndustry;
import com.hronline.entity.JobLocation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface JobLocationMapper {
    @Mapping(source = "createdDate", target = "createdDate", dateFormat = "dd/MM/yyyy HH:mm:ss")
    @Mapping(source = "modifyDate", target = "modifyDate", dateFormat = "dd/MM/yyyy HH:mm:ss")
    JobLocationDto toDto(JobLocation jobLocation);

    PaginationDto<JobLocationDto> toPaginationDto(PaginationDto<JobLocation> jobLocationPagination);
}
