package com.hronline.services;

import com.hronline.dto.BasicResponseDto;
import com.hronline.dto.CorporationDto;
import com.hronline.dto.PaginationDto;
import com.hronline.entity.Corporation;
import com.hronline.exception.BindingResultException;
import com.hronline.vm.DeleteEntityVM;
import com.hronline.vm.corp.CorpSearchVM;
import com.hronline.vm.corp.CreateCorpVM;
import com.hronline.vm.corp.UpdateCorpVM;

import java.util.List;
import java.util.Optional;

public interface CorpService {
    void save(CreateCorpVM createCorpVM);
    BasicResponseDto<PaginationDto<CorporationDto>> search(CorpSearchVM searchVM);

    BasicResponseDto<Void> delete(DeleteEntityVM deleteEntityVM);

    Optional<Corporation> findById(String id);

    void update(UpdateCorpVM updateCorpVM) throws BindingResultException;

    List<CorporationDto> findAll();
}
