package com.hronline.mapper;

import com.hronline.dto.CorporationDto;
import com.hronline.dto.PaginationDto;
import com.hronline.entity.Corporation;
import com.hronline.entity.Industry;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CorporationMapper {
    static CorporationDto toDto(Corporation corporation) {
        if (corporation == null)
            return null;
        else
            return CorporationDto.builder()
                .id(corporation.getId())
                .name(corporation.getName())
                .taxId(corporation.getTaxId())
                .address(corporation.getAddress())
                .description(corporation.getDescription())
                .phone(corporation.getPhone())
                .website(corporation.getWebsite())
                .industries(corporation.getIndustries().stream().map(Industry::getName).collect(Collectors.joining(",")))
                .build();
    }

    static List<CorporationDto> toListDto(List<Corporation> corporationList) {
        return corporationList.parallelStream().map(CorporationMapper::toDto).collect(Collectors.toList());
    }

    static PaginationDto<CorporationDto> toPaginationDto(PaginationDto<Corporation> corporationPaginationDto) {
        PaginationDto<CorporationDto> paginationDto = new PaginationDto<>();
        paginationDto.setDraw(corporationPaginationDto.getDraw());
        paginationDto.setRecordsFiltered(corporationPaginationDto.getRecordsFiltered());
        paginationDto.setRecordsTotal(corporationPaginationDto.getRecordsTotal());
        paginationDto.setData(toListDto(corporationPaginationDto.getData()));
        return paginationDto;
    };
}
