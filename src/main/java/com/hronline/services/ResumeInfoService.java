package com.hronline.services;

import com.hronline.dto.BasicResponseDto;
import com.hronline.dto.PaginationDto;
import com.hronline.dto.ResumeInfoDto;
import com.hronline.exception.BindingResultException;
import com.hronline.vm.resume.CreateResumeVM;
import com.hronline.vm.resume.ResumeSearchVM;

import java.io.IOException;

public interface ResumeInfoService {
    void save(CreateResumeVM createResumeVM) throws IOException, BindingResultException;

    BasicResponseDto<PaginationDto<ResumeInfoDto>> search(ResumeSearchVM searchVM);
}
