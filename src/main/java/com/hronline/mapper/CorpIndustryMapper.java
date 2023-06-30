package com.hronline.mapper;

import com.hronline.dto.CorpIndustryDto;
import com.hronline.entity.CorpIndustry;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CorpIndustryMapper {

    CorpIndustryDto toDto(CorpIndustry corpIndustry);
}
