package com.hronline.controller;

import org.keycloak.authorization.client.util.Http;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HandleErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, ModelAndView modelAndView) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {

            int statusInt = Integer.valueOf(String.valueOf(status));
            if (statusInt == HttpStatus.FORBIDDEN.value()) {
                return "error/accessDenied";
            } else if (statusInt == HttpStatus.NOT_FOUND.value()) {
                return "error/notFoundPage";
            } else {
                return "error/exception";
            }
        }
        return "error/exception";
    }
}
