package com.hronline.services;

import com.hronline.dto.BasicResponseDto;
import com.hronline.dto.CorpIndustryDto;
import com.hronline.dto.PaginationDto;
import com.hronline.entity.CorpIndustry;
import com.hronline.exception.BindingResultException;
import com.hronline.vm.CorpIndustrySearchVM;
import com.hronline.vm.CreateIndustryVM;
import com.hronline.vm.DeleteEntityVM;
import com.hronline.vm.UpdateCorpIndustryVM;

import java.util.Optional;

public interface CorpIndustryService {
    void save(CreateIndustryVM createIndustryVM);

    BasicResponseDto<PaginationDto<CorpIndustryDto>> search(CorpIndustrySearchVM searchVM);

    BasicResponseDto<Void> delete(DeleteEntityVM deleteEntityVM);

    void update(UpdateCorpIndustryVM updateCorpIndustryVM) throws BindingResultException;
    Optional<CorpIndustry> findById(String id);

}
