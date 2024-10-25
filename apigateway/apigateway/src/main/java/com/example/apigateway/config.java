package com.example.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class config {

    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("UserApplication", r -> r.path("/api/v1/users/**")
                        .uri("http://UserApplication")) // Load balanced URI
                .route("libraryservice", r -> r.path("/api/v1/books/**")
                        .uri("http://libraryservice")) // Load balanced URI
                .route("authentication-service", r -> r.path("/api/auth/**")
                        .uri("http://authentication-service")) // Load balanced URI
                .build();
    }
}

