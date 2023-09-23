package com.hronline.services.impl;

import com.hronline.dto.BasicResponseDto;
import com.hronline.dto.CorpIndustryDto;
import com.hronline.dto.PaginationDto;
import com.hronline.entity.CorpIndustry;
import com.hronline.exception.BindingResultException;
import com.hronline.mapper.CorpIndustryMapper;
import com.hronline.repository.CorpIndustryRepository;
import com.hronline.services.CommonSearchService;
import com.hronline.services.CorpIndustryService;
import com.hronline.vm.industry.CorpIndustrySearchVM;
import com.hronline.vm.industry.CreateIndustryVM;
import com.hronline.vm.DeleteEntityVM;
import com.hronline.vm.industry.UpdateCorpIndustryVM;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

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
    @Transactional
    public BasicResponseDto<PaginationDto<CorpIndustryDto>> search(CorpIndustrySearchVM searchVM) {
        PaginationDto<CorpIndustry> industryPagination = commonSearchService.searchData(searchVM, CorpIndustry.class);
        PaginationDto<CorpIndustryDto> response = corpIndustryMapper.toPaginationDto(industryPagination);
        return BasicResponseDto.ok(response);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public BasicResponseDto<Void> delete(DeleteEntityVM deleteEntityVM) {
         corpIndustryRepository.deleteAllById(deleteEntityVM.getIds());
         return BasicResponseDto.ok();
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void update(UpdateCorpIndustryVM updateCorpIndustryVM) throws BindingResultException {
        Optional<CorpIndustry> corpIndustryOptional = corpIndustryRepository.findById(updateCorpIndustryVM.getId());
        if (corpIndustryOptional.isEmpty()) {
            throw new BindingResultException("Id ngành nghề không tồn tại");
        }
        CorpIndustry corpIndustry = corpIndustryOptional.get();
        corpIndustry.setName(updateCorpIndustryVM.getName());
        corpIndustryRepository.save(corpIndustry);
    }

    @Override
    @Transactional
    public Optional<CorpIndustry> findById(String id) {
        return corpIndustryRepository.findById(id);
    }
}
