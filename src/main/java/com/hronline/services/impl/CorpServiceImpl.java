package com.hronline.services.impl;

import com.hronline.dto.BasicResponseDto;
import com.hronline.dto.CorporationDto;
import com.hronline.dto.IndustryDto;
import com.hronline.dto.PaginationDto;
import com.hronline.entity.Corporation;
import com.hronline.entity.Industry;
import com.hronline.exception.BindingResultException;
import com.hronline.mapper.CorporationMapper;
import com.hronline.repository.CorporationRepository;
import com.hronline.repository.IndustryRepository;
import com.hronline.services.CommonSearchService;
import com.hronline.services.CorpService;
import com.hronline.vm.DeleteEntityVM;
import com.hronline.vm.corp.CorpSearchVM;
import com.hronline.vm.corp.CreateCorpVM;
import com.hronline.vm.corp.UpdateCorpVM;
import com.hronline.vm.industry.IndustrySearchVM;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CorpServiceImpl implements CorpService {

    private final CorporationRepository corporationRepository;
    private final IndustryRepository industryRepository;
    private final CommonSearchService<Corporation, CorpSearchVM> commonSearchService;
    private final CorporationMapper corporationMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(CreateCorpVM request) {
        Set<Industry> industries = industryRepository.findAllByIdIn(request.getIndustries());

        Corporation corporation = Corporation.builder()
                .name(request.getName())
                .address(request.getAddress())
                .taxId(request.getTaxId())
                .phone(request.getPhone())
                .description(request.getDescription())
                .website(request.getWebsite())
                .industries(industries)
                .build();
        industries.forEach(item -> {
            item.getCorporations().add(corporation);
        });
        corporationRepository.save(corporation);
        industryRepository.saveAll(industries);
    }

    @Override
    @Transactional
    public BasicResponseDto<PaginationDto<CorporationDto>> search(CorpSearchVM searchVM) {
        PaginationDto<Corporation> corporationPagination = commonSearchService.searchData(searchVM, Corporation.class);
        PaginationDto<CorporationDto> response = CorporationMapper.toPaginationDto(corporationPagination);
        return BasicResponseDto.ok(response);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BasicResponseDto<Void> delete(DeleteEntityVM deleteEntityVM) {
        corporationRepository.deleteAllById(deleteEntityVM.getIds());
        return BasicResponseDto.ok();
    }

    @Override
    @Transactional
    public Optional<Corporation> findById(String id) {
        return corporationRepository.findById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(UpdateCorpVM request) throws BindingResultException {
        Set<Industry> industries = industryRepository.findAllByIdIn(request.getIndustries());
        if (industries.isEmpty()) {
            throw new BindingResultException("Id ngành nghề không tồn tại");
        }

        Optional<Corporation> corporationOptional = corporationRepository.findById(request.getId());
        if (corporationOptional.isEmpty())
            throw new BindingResultException("Id công ty không tồn tại");
        Corporation corporation = corporationOptional.get();
       corporation.setName(request.getName());
       corporation.setAddress(request.getAddress());
       corporation.setTaxId(request.getTaxId());
       corporation.setPhone(request.getPhone());
       corporation.setDescription(request.getDescription());
       corporation.setWebsite(request.getWebsite());

       corporation.getIndustries().forEach(item -> {
           item.getCorporations().remove(corporation);
       });
        corporation.setIndustries(industries);


        industries.forEach(item -> {
            item.getCorporations().add(corporation);
        });
        corporationRepository.save(corporation);
        industryRepository.saveAll(industries);
    }

    @Override
    @Transactional
    public List<CorporationDto> findAll() {
        return CorporationMapper.toListDto(corporationRepository.findAll());
    }
}
