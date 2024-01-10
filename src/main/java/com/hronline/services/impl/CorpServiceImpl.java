package com.hronline.services.impl;

import com.hronline.entity.Corporation;
import com.hronline.repository.CorporationRepository;
import com.hronline.services.CorpService;
import com.hronline.vm.corp.CreateCorpVM;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CorpServiceImpl implements CorpService {

    private final CorporationRepository corporationRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(CreateCorpVM createCorpVM) {
        Corporation corporation = Corporation.builder().build();
        corporationRepository.save(corporation);
    }
}
