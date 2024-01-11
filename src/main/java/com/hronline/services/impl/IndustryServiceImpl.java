package com.hronline.services.impl;

import com.hronline.dto.BasicResponseDto;
import com.hronline.dto.IndustryDto;
import com.hronline.dto.PaginationDto;
import com.hronline.entity.Industry;
import com.hronline.exception.BindingResultException;
import com.hronline.mapper.IndustryMapper;
import com.hronline.repository.IndustryRepository;
import com.hronline.services.CommonSearchService;
import com.hronline.services.IndustryService;
import com.hronline.vm.industry.IndustrySearchVM;
import com.hronline.vm.industry.CreateIndustryVM;
import com.hronline.vm.DeleteEntityVM;
import com.hronline.vm.industry.UpdateIndustryVM;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class IndustryServiceImpl implements IndustryService {

    private final IndustryRepository industryRepository;
    private final IndustryMapper industryMapper;
    private final CommonSearchService<Industry, IndustrySearchVM> commonSearchService;

    public IndustryServiceImpl(IndustryRepository industryRepository,
                               IndustryMapper industryMapper,
                               CommonSearchService<Industry, IndustrySearchVM> commonSearchService) {
        this.industryRepository = industryRepository;
        this.commonSearchService = commonSearchService;
        this.industryMapper = industryMapper;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void save(CreateIndustryVM createIndustryVM) {
        Industry industry = Industry.builder()
                .name(createIndustryVM.getName())
                .build();
        industryRepository.save(industry);
    }

    @Override
    @Transactional
    public BasicResponseDto<PaginationDto<IndustryDto>> search(IndustrySearchVM searchVM) {
        PaginationDto<Industry> industryPagination = commonSearchService.searchData(searchVM, Industry.class);
        PaginationDto<IndustryDto> response = industryMapper.toPaginationDto(industryPagination);
        return BasicResponseDto.ok(response);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public BasicResponseDto<Void> delete(DeleteEntityVM deleteEntityVM) {
         industryRepository.deleteAllById(deleteEntityVM.getIds());
         return BasicResponseDto.ok();
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void update(UpdateIndustryVM updateIndustryVM) throws BindingResultException {
        Optional<Industry> corpIndustryOptional = industryRepository.findById(updateIndustryVM.getId());
        if (corpIndustryOptional.isEmpty()) {
            throw new BindingResultException("Id ngành nghề không tồn tại");
        }
        Industry industry = corpIndustryOptional.get();
        industry.setName(updateIndustryVM.getName());
        industryRepository.save(industry);
    }

    @Override
    @Transactional
    public Optional<Industry> findById(String id) {
        return industryRepository.findById(id);
    }

    @Override
    @Transactional
    public List<IndustryDto> findAll() {
        List<Industry> industries = industryRepository.findAll();
        return industryMapper.toListDto(industries);
    }
}
