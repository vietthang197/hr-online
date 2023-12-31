package com.hronline.controller;

import com.hronline.dto.*;
import com.hronline.entity.Industry;
import com.hronline.entity.JobLocation;
import com.hronline.entity.JobTitle;
import com.hronline.exception.BindingResultException;
import com.hronline.services.IndustryService;
import com.hronline.services.JobLocationService;
import com.hronline.services.JobTitleService;
import com.hronline.util.HrConstant;
import com.hronline.vm.industry.IndustrySearchVM;
import com.hronline.vm.industry.CreateIndustryVM;
import com.hronline.vm.DeleteEntityVM;
import com.hronline.vm.industry.UpdateIndustryVM;
import com.hronline.vm.jobTitle.CreateJobTitleVM;
import com.hronline.vm.jobTitle.JobTitleSearchVM;
import com.hronline.vm.jobTitle.UpdateJobTitleVM;
import com.hronline.vm.location.CreateJobLocationVM;
import com.hronline.vm.location.JobLocationSearchVM;
import com.hronline.vm.location.UpdateJobLocationVM;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IndustryService industryService;

    @Autowired
    private JobLocationService jobLocationService;

    @Autowired
    private JobTitleService jobTitleService;

    @GetMapping
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Admin Resource', 'urn:servlet-authz:protected:admin:access')")
    public String adminHome(HttpServletRequest request) {
        return "redirect:/admin/job";
    }

    @GetMapping("/job")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Admin Resource', 'urn:servlet-authz:protected:admin:access')")
    public String jobList(HttpServletRequest request) {
        return "admin/job/jobList";
    }

    @GetMapping("/job/create")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Admin Resource', 'urn:servlet-authz:protected:admin:access')")
    public String createJob(HttpServletRequest request) {
        return "admin/job/createJob";
    }

    @GetMapping("/employee")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Admin Resource', 'urn:servlet-authz:protected:admin:access')")
    public String employeeList(HttpServletRequest request) {
        return "admin/resume/resumableList";
    }

    @GetMapping("/corp")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Admin Resource', 'urn:servlet-authz:protected:admin:access')")
    public String corpList(HttpServletRequest request) {
        return "admin/corp/corpList";
    }

    @GetMapping("/corp/create")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Admin Resource', 'urn:servlet-authz:protected:admin:access')")
    public String createCorp(HttpServletRequest request) {
        return "admin/corp/createCorp";
    }

    @GetMapping("/corp-industry")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Admin Resource', 'urn:servlet-authz:protected:admin:access')")
    public String corpIndustryList(HttpServletRequest request) {
        return "admin/industry/industryList";
    }

    @GetMapping("/corp-industry/create")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Admin Resource', 'urn:servlet-authz:protected:admin:access')")
    public String createIdustry(HttpServletRequest request) {
        return "admin/industry/createIndustry";
    }

    @PostMapping("/corp-industry/create")
    @PreAuthorize("@oauth2Security.hasMultipleResourcePermission(#request, T(java.util.Arrays).asList(new com.hronline.obj.AuthzRequest('Admin Resource', T(java.util.Arrays).asList('urn:servlet-authz:protected:admin:access')), new com.hronline.obj.AuthzRequest('Corp Industry Resource', T(java.util.Arrays).asList('urn:servlet-authz:protected:admin:industry:create'))))")
    public String createIndustrySubmit(HttpServletRequest request, @Valid @ModelAttribute CreateIndustryVM createIndustryVM, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute(HrConstant.ATTRIBUTE_ERROR_LIST, bindingResult.getAllErrors());
            return "redirect:/admin/corp-industry/create";
        }
        industryService.save(createIndustryVM);
        redirectAttributes.addFlashAttribute(HrConstant.ATTRIBUTE_SUCCCES_MESSAGE, "Thêm mới ngành nghề thành công");
        return "redirect:/admin/corp-industry/create";
    }

    @PostMapping("/corp-industry/search")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Admin Resource', 'urn:servlet-authz:protected:admin:access')")
    @ResponseBody
    public BasicResponseDto<PaginationDto<IndustryDto>> searchIndustry(HttpServletRequest request, @Valid @RequestBody IndustrySearchVM searchVM) {
        return industryService.search(searchVM);
    }

    @DeleteMapping("/corp-industry/delete")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Corp Industry Resource', 'urn:servlet-authz:protected:admin:industry:delete')")
    @ResponseBody
    public BasicResponseDto<Void> deleteCorpIndustry(HttpServletRequest request, @Valid @RequestBody DeleteEntityVM deleteEntityVM) {
        return industryService.delete(deleteEntityVM);
    }

    @GetMapping("/corp-industry/edit/{id}")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Corp Industry Resource', 'urn:servlet-authz:protected:admin:industry:edit')")
    public String corpIndustryEdit(HttpServletRequest request, HttpServletResponse response, @Valid @NotBlank @PathVariable String id, Model model) throws IOException {
        Optional<Industry> corpIndustryOptional = industryService.findById(id);
        if (corpIndustryOptional.isEmpty()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            model.addAttribute("name", corpIndustryOptional.get().getName());
        }
        model.addAttribute("id", id);
        return "admin/industry/industryEdit";
    }

    @PostMapping("/corp-industry/edit")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Corp Industry Resource', 'urn:servlet-authz:protected:admin:industry:edit')")
    public String corpIndustryEdit(HttpServletRequest request, @Valid @ModelAttribute UpdateIndustryVM updateIndustryVM, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute(HrConstant.ATTRIBUTE_ERROR_LIST, bindingResult.getAllErrors());
            return "redirect:/admin/corp-industry/edit/" + updateIndustryVM.getId();
        }
        try {
            industryService.update(updateIndustryVM);
        } catch (BindingResultException e) {
            bindingResult.reject(String.valueOf(HttpStatus.SC_BAD_REQUEST), e.getMessage());
            return "redirect:/admin/corp-industry/edit/" + updateIndustryVM.getId();
        }
        return "redirect:/admin/corp-industry";
    }

    @GetMapping("/job-location")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Admin Resource', 'urn:servlet-authz:protected:admin:access')")
    public String jobLocationList(HttpServletRequest request) {
        return "admin/jobLocation/jobLocationList";
    }

    @GetMapping("/job-location/create")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Admin Resource', 'urn:servlet-authz:protected:admin:access')")
    public String createJobLocation(HttpServletRequest request) {
        return "admin/jobLocation/createJobLocation";
    }

    @PostMapping("/job-location/create")
    @PreAuthorize("@oauth2Security.hasMultipleResourcePermission(#request, T(java.util.Arrays).asList(new com.hronline.obj.AuthzRequest('Admin Resource', T(java.util.Arrays).asList('urn:servlet-authz:protected:admin:access')), new com.hronline.obj.AuthzRequest('Corp Location Resource', T(java.util.Arrays).asList('urn:servlet-authz:protected:admin:job-location:create'))))")
    public String createLocationSubmit(HttpServletRequest request, @Valid @ModelAttribute CreateJobLocationVM createJobLocationVM, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute(HrConstant.ATTRIBUTE_ERROR_LIST, bindingResult.getAllErrors());
            return "redirect:/admin/job-location/create";
        }
        jobLocationService.save(createJobLocationVM);
        redirectAttributes.addFlashAttribute(HrConstant.ATTRIBUTE_SUCCCES_MESSAGE, "Thêm mới địa chỉ thành công");
        return "redirect:/admin/job-location/create";
    }

    @PostMapping("/job-location/search")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Admin Resource', 'urn:servlet-authz:protected:admin:access')")
    @ResponseBody
    public BasicResponseDto<PaginationDto<JobLocationDto>> searchJobLocation(HttpServletRequest request, @Valid @RequestBody JobLocationSearchVM searchVM) {
        return jobLocationService.search(searchVM);
    }

    @GetMapping("/job-location/edit/{id}")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Corp Location Resource', 'urn:servlet-authz:protected:admin:job-location:edit')")
    public String jobLocationEdit(HttpServletRequest request, HttpServletResponse response, @Valid @NotBlank @PathVariable String id, Model model) throws IOException {
        Optional<JobLocation> jobLocationOptional = jobLocationService.findById(id);
        if (jobLocationOptional.isEmpty()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            model.addAttribute("name", jobLocationOptional.get().getName());
        }
        model.addAttribute("id", id);
        return "admin/jobLocation/jobLocationEdit";
    }

    @PostMapping("/job-location/edit")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Corp Location Resource', 'urn:servlet-authz:protected:admin:job-location:edit')")
    public String jobLocationEdit(HttpServletRequest request, @Valid @ModelAttribute UpdateJobLocationVM updateJobLocationVM, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute(HrConstant.ATTRIBUTE_ERROR_LIST, bindingResult.getAllErrors());
            return "redirect:/admin/job-location/edit/" + updateJobLocationVM.getId();
        }
        try {
            jobLocationService.update(updateJobLocationVM);
        } catch (BindingResultException e) {
            bindingResult.reject(String.valueOf(HttpStatus.SC_BAD_REQUEST), e.getMessage());
            return "redirect:/admin/job-location/edit/" + updateJobLocationVM.getId();
        }
        return "redirect:/admin/job-location";
    }

    @DeleteMapping("/job-location/delete")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Corp Location Resource', 'urn:servlet-authz:protected:admin:job-location:delete')")
    @ResponseBody
    public BasicResponseDto<Void> deleteJobLocation(HttpServletRequest request, @Valid @RequestBody DeleteEntityVM deleteEntityVM) {
        return jobLocationService.delete(deleteEntityVM);
    }

    @GetMapping("/job-title")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Admin Resource', 'urn:servlet-authz:protected:admin:access')")
    public String jobTitleList(HttpServletRequest request) {
        return "admin/jobTitle/jobTitleList";
    }

    @PostMapping("/job-title/search")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Admin Resource', 'urn:servlet-authz:protected:admin:access')")
    @ResponseBody
    public BasicResponseDto<PaginationDto<JobTitleDto>> searchJobTitle(HttpServletRequest request, @Valid @RequestBody JobTitleSearchVM searchVM) {
        return jobTitleService.search(searchVM);
    }

    @GetMapping("/job-title/create")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Admin Resource', 'urn:servlet-authz:protected:admin:access')")
    public String createJobTitle(HttpServletRequest request) {
        return "admin/jobTitle/createJobTitle";
    }

    @PostMapping("/job-title/create")
    @PreAuthorize("@oauth2Security.hasMultipleResourcePermission(#request, T(java.util.Arrays).asList(new com.hronline.obj.AuthzRequest('Admin Resource', T(java.util.Arrays).asList('urn:servlet-authz:protected:admin:access')), new com.hronline.obj.AuthzRequest('Corp JobTitle Resource', T(java.util.Arrays).asList('urn:servlet-authz:protected:admin:job-title:create'))))")
    public String createJobTitleSubmit(HttpServletRequest request, @Valid @ModelAttribute CreateJobTitleVM createJobTitleVM, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute(HrConstant.ATTRIBUTE_ERROR_LIST, bindingResult.getAllErrors());
            return "redirect:/admin/job-title/create";
        }
        jobTitleService.save(createJobTitleVM);
        redirectAttributes.addFlashAttribute(HrConstant.ATTRIBUTE_SUCCCES_MESSAGE, "Thêm mới chức vụ thành công");
        return "redirect:/admin/job-title/create";
    }

    @GetMapping("/job-title/edit/{id}")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Corp JobTitle Resource', 'urn:servlet-authz:protected:admin:job-title:edit')")
    public String jobTitleEdit(HttpServletRequest request, HttpServletResponse response, @Valid @NotBlank @PathVariable String id, Model model) throws IOException {
        Optional<JobTitle> jobTitleOptional = jobTitleService.findById(id);
        if (jobTitleOptional.isEmpty()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            model.addAttribute("name", jobTitleOptional.get().getName());
        }
        model.addAttribute("id", id);
        return "admin/jobTitle/jobTitleEdit";
    }

    @PostMapping("/job-title/edit")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Corp JobTitle Resource', 'urn:servlet-authz:protected:admin:job-title:edit')")
    public String jobTitleEdit(HttpServletRequest request, @Valid @ModelAttribute UpdateJobTitleVM updateJobTitleVM, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute(HrConstant.ATTRIBUTE_ERROR_LIST, bindingResult.getAllErrors());
            return "redirect:/admin/job-title/edit/" + updateJobTitleVM.getId();
        }
        try {
            jobTitleService.update(updateJobTitleVM);
        } catch (BindingResultException e) {
            bindingResult.reject(String.valueOf(HttpStatus.SC_BAD_REQUEST), e.getMessage());
            return "redirect:/admin/job-title/edit/" + updateJobTitleVM.getId();
        }
        return "redirect:/admin/job-title";
    }

    @DeleteMapping("/job-title/delete")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Corp JobTitle Resource', 'urn:servlet-authz:protected:admin:job-title:delete')")
    @ResponseBody
    public BasicResponseDto<Void> deleteJobTitle(HttpServletRequest request, @Valid @RequestBody DeleteEntityVM deleteEntityVM) {
        return jobTitleService.delete(deleteEntityVM);
    }
}
