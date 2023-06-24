package com.hronline.controller;

import com.hronline.config.Oauth2Security;
import com.hronline.vm.CreateIndustryVM;
import org.keycloak.KeycloakPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

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

    @GetMapping("/industry")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Admin Resource', 'urn:servlet-authz:protected:admin:access')")
    public String corpIndustryList(HttpServletRequest request) {
        return "admin/industry/industryList";
    }

    @GetMapping("/industry/create")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Admin Resource', 'urn:servlet-authz:protected:admin:access')")
    public String createIdustry(HttpServletRequest request) {
        return "admin/industry/createIndustry";
    }

    @PostMapping("/industry/create")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Admin Resource', 'urn:servlet-authz:protected:admin:access')")
    public String createIndustrySubmit(HttpServletRequest request, @Valid @ModelAttribute CreateIndustryVM createIndustryVM, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("errorList", bindingResult.getAllErrors());
            return "redirect:/admin/industry/create";
        }
        redirectAttributes.addFlashAttribute("successMessage", "Thêm mới ngành nghề thành công");
        return "redirect:/admin/industry/create";
    }
}
