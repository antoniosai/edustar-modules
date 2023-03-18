package com.edustar.gateway.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edustar.gateway.model.AuthTokenModel;
import com.edustar.gateway.service.AuthService;

@RefreshScope
@RestController
@RequestMapping("/fallback")
public class HystrixController {

    @Autowired
    private AuthService authService;

    @GetMapping("/first")
    public String firstServiceFallback() {
        return "This is a fallback for first service.";
    }

    @GetMapping("/second")
    public String secondServiceFallback() {
        return "Second Server overloaded! Please try after some time.";
    }

    @GetMapping("/test")
    public AuthTokenModel testServiceFallback() {
        return authService.getJWTToken("1231");
    }

}