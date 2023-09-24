package com.hronline.mapper;

import com.hronline.dto.JobLocationDto;
import com.hronline.dto.JobTitleDto;
import com.hronline.dto.PaginationDto;
import com.hronline.entity.JobLocation;
import com.hronline.entity.JobTitle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface JobTitleMapper {

    @Mapping(source = "createdDate", target = "createdDate", dateFormat = "dd/MM/yyyy HH:mm:ss")
    @Mapping(source = "modifyDate", target = "modifyDate", dateFormat = "dd/MM/yyyy HH:mm:ss")
    JobTitleDto toDto(JobTitle jobTitle);
    PaginationDto<JobTitleDto> toPaginationDto(PaginationDto<JobTitle> jobTitlePagination);
}
