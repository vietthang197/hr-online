package com.hronline.mapper;

import com.hronline.dto.IndustryDto;
import com.hronline.dto.PaginationDto;
import com.hronline.entity.Industry;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IndustryMapper {

    @Mapping(source = "createdDate", target = "createdDate", dateFormat = "dd/MM/yyyy HH:mm:ss")
    @Mapping(source = "modifyDate", target = "modifyDate", dateFormat = "dd/MM/yyyy HH:mm:ss")
    IndustryDto toDto(Industry industry);

    PaginationDto<IndustryDto> toPaginationDto(PaginationDto<Industry> corpIndustryPagination);
}
