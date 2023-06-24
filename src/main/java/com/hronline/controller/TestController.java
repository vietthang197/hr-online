package com.hronline.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class TestController {
    @GetMapping("/test")
    @PreAuthorize("@oauth2Security.authenticated")
    public String test(HttpServletRequest request) {
        return "user/index";
    }

    @GetMapping("/admin")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Admin Resource', 'urn:servlet-authz:protected:admin:access')")
    public String admin(HttpServletRequest request) {
        return "admin/index";
    }
}
