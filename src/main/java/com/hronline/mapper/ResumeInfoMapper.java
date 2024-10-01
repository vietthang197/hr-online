package com.hronline.mapper;

import com.hronline.dto.CorporationDto;
import com.hronline.dto.IndustryDto;
import com.hronline.dto.PaginationDto;
import com.hronline.dto.ResumeInfoDto;
import com.hronline.entity.Corporation;
import com.hronline.entity.Industry;
import com.hronline.entity.ResumeInfo;
import com.hronline.util.DateUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ResumeInfoMapper {
    static ResumeInfoDto toDto(ResumeInfo resumeInfo, JobLocationMapper jobLocationMapper, FileUploadManagementMapper fileUploadManagementMapper) {
        return ResumeInfoDto.builder()
                .applicantName(resumeInfo.getApplicantName())
                .applicantEmail(resumeInfo.getApplicantEmail())
                .applicantPhone(resumeInfo.getApplicantPhone())
                .applicantFbLink(resumeInfo.getApplicantFbLink())
                .createdDate(DateUtils.fromDate(resumeInfo.getCreatedDate(), DateUtils.DEFAULT_DATE_FORMAT))
                .id(resumeInfo.getId())
                .jobInfo(JobInfoMapper.toDto(resumeInfo.getJobInfo(), jobLocationMapper))
                .fileResume(fileUploadManagementMapper.toDto(resumeInfo.getFileResume()))
                .build();
    };

    static List<ResumeInfoDto> toListDto(List<ResumeInfo> resumeInfoList, JobLocationMapper jobLocationMapper, FileUploadManagementMapper fileUploadManagementMapper) {
        return resumeInfoList.parallelStream().map(item -> ResumeInfoMapper.toDto(item, jobLocationMapper, fileUploadManagementMapper)).collect(Collectors.toList());
    }

    static PaginationDto<ResumeInfoDto> toPaginationDto(PaginationDto<ResumeInfo> resumeInfoPaginationDto, JobLocationMapper jobLocationMapper, FileUploadManagementMapper fileUploadManagementMapper) {
        PaginationDto<ResumeInfoDto> paginationDto = new PaginationDto<>();
        paginationDto.setDraw(resumeInfoPaginationDto.getDraw());
        paginationDto.setRecordsFiltered(resumeInfoPaginationDto.getRecordsFiltered());
        paginationDto.setRecordsTotal(resumeInfoPaginationDto.getRecordsTotal());
        paginationDto.setData(toListDto(resumeInfoPaginationDto.getData(), jobLocationMapper, fileUploadManagementMapper));
        return paginationDto;
    };
}
