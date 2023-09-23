package com.hronline.controller;

import com.hronline.dto.BasicResponseDto;
import com.hronline.dto.CorpIndustryDto;
import com.hronline.dto.PaginationDto;
import com.hronline.entity.CorpIndustry;
import com.hronline.exception.BindingResultException;
import com.hronline.services.CorpIndustryService;
import com.hronline.services.JobLocationService;
import com.hronline.util.HrConstant;
import com.hronline.vm.industry.CorpIndustrySearchVM;
import com.hronline.vm.industry.CreateIndustryVM;
import com.hronline.vm.DeleteEntityVM;
import com.hronline.vm.industry.UpdateCorpIndustryVM;
import com.hronline.vm.location.CreateJobLocationVM;
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
    private CorpIndustryService corpIndustryService;

    @Autowired
    private JobLocationService jobLocationService;

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
        corpIndustryService.save(createIndustryVM);
        redirectAttributes.addFlashAttribute(HrConstant.ATTRIBUTE_SUCCCES_MESSAGE, "Thêm mới ngành nghề thành công");
        return "redirect:/admin/corp-industry/create";
    }

    @PostMapping("/corp-industry/search")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Admin Resource', 'urn:servlet-authz:protected:admin:access')")
    @ResponseBody
    public BasicResponseDto<PaginationDto<CorpIndustryDto>> searchIndustry(HttpServletRequest request, @Valid @RequestBody CorpIndustrySearchVM searchVM) {
        return corpIndustryService.search(searchVM);
    }

    @DeleteMapping("/corp-industry/delete")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Corp Industry Resource', 'urn:servlet-authz:protected:admin:industry:delete')")
    @ResponseBody
    public BasicResponseDto<Void> deleteCorpIndustry(HttpServletRequest request, @Valid @RequestBody DeleteEntityVM deleteEntityVM) {
        return corpIndustryService.delete(deleteEntityVM);
    }

    @GetMapping("/corp-industry/edit/{id}")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Corp Industry Resource', 'urn:servlet-authz:protected:admin:industry:edit')")
    public String corpIndustryEdit(HttpServletRequest request, HttpServletResponse response, @Valid @NotBlank @PathVariable String id, Model model) throws IOException {
        Optional<CorpIndustry> corpIndustryOptional = corpIndustryService.findById(id);
        if (corpIndustryOptional.isEmpty()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            model.addAttribute("corpIndustryName", corpIndustryOptional.get().getName());
        }
        model.addAttribute("corpIndustryId", id);
        return "admin/industry/industryEdit";
    }

    @PostMapping("/corp-industry/edit")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Corp Industry Resource', 'urn:servlet-authz:protected:admin:industry:edit')")
    public String corpIndustryEdit(HttpServletRequest request, @Valid @ModelAttribute UpdateCorpIndustryVM updateCorpIndustryVM, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute(HrConstant.ATTRIBUTE_ERROR_LIST, bindingResult.getAllErrors());
            return "redirect:/admin/corp-industry/edit/" + updateCorpIndustryVM.getId();
        }
        try {
            corpIndustryService.update(updateCorpIndustryVM);
        } catch (BindingResultException e) {
            bindingResult.reject(String.valueOf(HttpStatus.SC_BAD_REQUEST), e.getMessage());
            return "redirect:/admin/corp-industry/edit/" + updateCorpIndustryVM.getId();
        }
        return "redirect:/admin/corp-industry";
    }

    @GetMapping("/job-location")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Admin Resource', 'urn:servlet-authz:protected:admin:access')")
    public String jobLocationList(HttpServletRequest request) {
        return "admin/jobLocation/jobLocationList";
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
}
