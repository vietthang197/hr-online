package com.hronline.controller;

import com.hronline.dto.JobInfoDto;
import com.hronline.exception.BindingResultException;
import com.hronline.services.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

    private final JobService jobService;

    @GetMapping("/")
    public String homePage(Model model) {
        List<JobInfoDto> jobInfoDtos = jobService.findLatestJob(6);
        model.addAttribute("jobs", jobInfoDtos);
        return "public/index";
    }

    @GetMapping("/job-detail/{jobId}")
    public String jobDetail(@PathVariable @NotBlank @Valid String jobId, Model model) throws BindingResultException {
        JobInfoDto jobInfoDto = jobService.findById(jobId);
        model.addAttribute("job", jobInfoDto);
        return "public/jobDetail";
    }

    @GetMapping("/search-job")
    public String searchJob() {
        return "public/searchJob";
    }

    @GetMapping("/blog")
    public String blog() {
        return "public/blog";
    }

    @GetMapping("/about")
    public String about() {
        return "public/about";
    }

}
