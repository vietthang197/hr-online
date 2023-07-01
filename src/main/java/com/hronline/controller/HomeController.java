package com.hronline.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String homePage() {
        return "public/index";
    }

    @GetMapping("/job-detail")
    public String jobDetail() {
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
