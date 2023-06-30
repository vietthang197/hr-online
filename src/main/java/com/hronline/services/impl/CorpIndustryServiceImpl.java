package com.hronline.services.impl;

import com.hronline.dto.BasicResponseDto;
import com.hronline.dto.CorpIndustryDto;
import com.hronline.dto.PaginationDto;
import com.hronline.entity.CorpIndustry;
import com.hronline.mapper.CorpIndustryMapper;
import com.hronline.repository.CorpIndustryRepository;
import com.hronline.services.CommonSearchService;
import com.hronline.services.CorpIndustryService;
import com.hronline.vm.CorpIndustrySearchVM;
import com.hronline.vm.CreateIndustryVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CorpIndustryServiceImpl implements CorpIndustryService {

    private final CorpIndustryRepository corpIndustryRepository;
    private final CorpIndustryMapper corpIndustryMapper;
    private final CommonSearchService<CorpIndustry, CorpIndustrySearchVM> commonSearchService;

    public CorpIndustryServiceImpl(CorpIndustryRepository corpIndustryRepository,
                                   CorpIndustryMapper corpIndustryMapper,
                                   CommonSearchService<CorpIndustry, CorpIndustrySearchVM> commonSearchService) {
        this.corpIndustryRepository = corpIndustryRepository;
        this.commonSearchService = commonSearchService;
        this.corpIndustryMapper = corpIndustryMapper;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void save(CreateIndustryVM createIndustryVM) {
        CorpIndustry corpIndustry = CorpIndustry.builder()
                .name(createIndustryVM.getName())
                .build();
        corpIndustryRepository.save(corpIndustry);
    }

    @Override
    public BasicResponseDto<PaginationDto<CorpIndustryDto>> search(CorpIndustrySearchVM searchVM) {
        PaginationDto<CorpIndustry> industryPagination = commonSearchService.searchData(searchVM, CorpIndustry.class);
        PaginationDto<CorpIndustryDto> response = corpIndustryMapper.toPaginationDto(industryPagination);
        return BasicResponseDto.ok(response);
    }
}
