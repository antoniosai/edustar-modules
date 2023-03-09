package com.edustar.gateway.config.properties;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * Custom configuration properties for Gateway
 *
 * @author akash gupta
 */
@Getter
@Setter
@ToString
@Configuration
@ConfigurationProperties("custom.gateway")
@RefreshScope
@Slf4j
public class GatewayCustomProperties {

    private boolean exposeUnsecuredUrls = false;
    private List<String> unsecuredUrls = new ArrayList<>();

    @PostConstruct
    public void logGatewayCustomProperties() {
        log.info("***** Gateway Custom Properties: {} *****", toString());
    }

}
