package com.hronline.controller;

import com.hronline.dto.JobInfoDto;
import com.hronline.exception.BindingResultException;
import com.hronline.services.JobLocationService;
import com.hronline.services.JobService;
import com.hronline.services.ResumeInfoService;
import com.hronline.vm.resume.CreateResumeVM;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

    private final JobService jobService;
    private final ResumeInfoService resumeInfoService;
    private final JobLocationService jobLocationService;

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
    public String searchJob(Model model) {
        model.addAttribute("locations", jobLocationService.findAll());
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

    @PostMapping("/submit-resume")
    public String submitResume(@ModelAttribute @Valid CreateResumeVM createResumeVM, RedirectAttributes redirectAttributes) throws IOException, BindingResultException {
        resumeInfoService.save(createResumeVM);
        redirectAttributes.addFlashAttribute("submitResumeResult", "Hệ thống đã ghi nhận CV của ứng viên");
        return "redirect:/job-detail/" + createResumeVM.getJobId();
    }
}
