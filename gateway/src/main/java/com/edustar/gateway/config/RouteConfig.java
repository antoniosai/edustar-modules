package com.edustar.gateway.config;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.Route.AsyncBuilder;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Autowired
    private AuthFilter authFilter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        System.out.println("OK ROUTE LOCATOR");
        return builder.routes()
            .route("master", r -> r.path("/master/**")

                //
                .filters(f -> f
                    //
                    //.rewritePath("/api/v1/(?<segment>.*)", "/service/api/v1/${segment}")
                    //
                    .removeRequestHeader("Authorization")
                    .filter(authFilter.apply(new AuthFilterConfig())))
                .uri("lb://master"))
            .build();
    }

}
