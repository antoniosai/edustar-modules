package com.edustar.gateway.service;

import com.edustar.gateway.config.FeignConfig;
import com.edustar.gateway.model.AuthTokenModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;



@FeignClient(value = "${auth.serviceid}", url = "http://localhost:8888/")
public interface AuthService {

    @GetMapping(value = "/jwt/auth/generate")
    public AuthTokenModel getJWTToken(@RequestHeader("apikey") String apiKey);

}