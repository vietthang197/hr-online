package com.hronline.services.impl;

import com.hronline.dto.BasicResponseDto;
import com.hronline.dto.FileUploadManagementDto;
import com.hronline.dto.PaginationDto;
import com.hronline.dto.ResumeInfoDto;
import com.hronline.entity.FileUploadManagement;
import com.hronline.entity.Industry;
import com.hronline.entity.JobInfo;
import com.hronline.entity.ResumeInfo;
import com.hronline.exception.BindingResultException;
import com.hronline.repository.FileUploadManagementRepository;
import com.hronline.repository.JobRepository;
import com.hronline.repository.ResumeInfoRepository;
import com.hronline.services.CommonSearchService;
import com.hronline.services.FileUploadManagementService;
import com.hronline.services.ResumeInfoService;
import com.hronline.util.HrConstant;
import com.hronline.vm.industry.IndustrySearchVM;
import com.hronline.vm.resume.CreateResumeVM;
import com.hronline.vm.resume.ResumeSearchVM;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.BindException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResumeInfoServiceImpl implements ResumeInfoService {
    private final ResumeInfoRepository resumeInfoRepository;
    private final FileUploadManagementService fileUploadManagementService;
    private final FileUploadManagementRepository fileUploadManagementRepository;
    private final JobRepository jobRepository;
    private final CommonSearchService<ResumeInfo, ResumeSearchVM> commonSearchService;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void save(CreateResumeVM createResumeVM) throws IOException, BindingResultException {

        Optional<JobInfo> jobInfoOptional = jobRepository.findById(createResumeVM.getJobId());
        if (jobInfoOptional.isEmpty())
            throw new BindingResultException("Job không tồn tại");
        JobInfo jobInfo = jobInfoOptional.get();

        FileUploadManagementDto fileResumeDto = fileUploadManagementService.saveSingleFile(createResumeVM.getFileResume());
        FileUploadManagement fileResume = FileUploadManagement.builder()
                .docCode(HrConstant.JD_CODE)
                .path(fileResumeDto.getPath())
                .size(fileResumeDto.getSize())
                .originFileName(fileResumeDto.getOriginFileName())
                .isDeleted(HrConstant.STR_N)
                .build();
        fileResume = fileUploadManagementRepository.save(fileResume);

        ResumeInfo resumeInfo = ResumeInfo.builder()
                .applicantName(createResumeVM.getApplicantName())
                .applicantEmail(createResumeVM.getApplicantEmail())
                .applicantFbLink(createResumeVM.getApplicantFbLink())
                .applicantPhone(createResumeVM.getApplicantPhone())
                .fileResume(fileResume)
                .jobInfo(jobInfo)
                .build();
        resumeInfoRepository.save(resumeInfo);
    }

    @Override
    @Transactional
    public BasicResponseDto<PaginationDto<ResumeInfoDto>> search(ResumeSearchVM searchVM) {
        return null;
    }
}
