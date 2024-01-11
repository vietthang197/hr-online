package com.hronline.services;

import com.hronline.dto.BasicResponseDto;
import com.hronline.dto.IndustryDto;
import com.hronline.dto.PaginationDto;
import com.hronline.entity.Industry;
import com.hronline.exception.BindingResultException;
import com.hronline.vm.industry.IndustrySearchVM;
import com.hronline.vm.industry.CreateIndustryVM;
import com.hronline.vm.DeleteEntityVM;
import com.hronline.vm.industry.UpdateIndustryVM;

import java.util.List;
import java.util.Optional;

public interface IndustryService {
    void save(CreateIndustryVM createIndustryVM);

    BasicResponseDto<PaginationDto<IndustryDto>> search(IndustrySearchVM searchVM);

    BasicResponseDto<Void> delete(DeleteEntityVM deleteEntityVM);

    void update(UpdateIndustryVM updateIndustryVM) throws BindingResultException;
    Optional<Industry> findById(String id);

    List<IndustryDto> findAll();

}
