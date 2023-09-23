package com.hronline.mapper;

import com.hronline.dto.JobLocationDto;
import com.hronline.entity.JobLocation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobLocationMapper {
    JobLocationDto toDto(JobLocation jobLocation);
}
