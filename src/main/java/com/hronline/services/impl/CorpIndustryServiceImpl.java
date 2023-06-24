package com.hronline.services.impl;

import com.hronline.entity.CorpIndustry;
import com.hronline.repository.CorpIndustryRepository;
import com.hronline.services.CorpIndustryService;
import com.hronline.vm.CreateIndustryVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CorpIndustryServiceImpl implements CorpIndustryService {

    @Autowired
    private CorpIndustryRepository corpIndustryRepository;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void save(CreateIndustryVM createIndustryVM) {
        CorpIndustry corpIndustry = CorpIndustry.builder()
                .name(createIndustryVM.getName())
                .build();
        corpIndustryRepository.save(corpIndustry);
    }
}
