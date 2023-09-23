package com.hronline.mapper;

import com.hronline.dto.CorpIndustryDto;
import com.hronline.dto.PaginationDto;
import com.hronline.entity.CorpIndustry;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CorpIndustryMapper {

    @Mapping(source = "createdDate", target = "createdDate", dateFormat = "dd/MM/yyyy HH:mm:ss")
    @Mapping(source = "modifyDate", target = "modifyDate", dateFormat = "dd/MM/yyyy HH:mm:ss")
    CorpIndustryDto toDto(CorpIndustry corpIndustry);

    PaginationDto<CorpIndustryDto> toPaginationDto(PaginationDto<CorpIndustry> corpIndustryPagination);
}
