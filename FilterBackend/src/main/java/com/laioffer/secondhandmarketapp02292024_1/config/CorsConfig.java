package com.laioffer.secondhandmarketapp02292024_1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:3000"); // Allows the frontend domain
        //config.addAllowedOrigin("localhost:3000");
        //config.addAllowedOrigin("http://192.168.1.110:3000");
        config.addAllowedOriginPattern("*");
        config.addAllowedHeader("*"); // Allows all headers
        config.addAllowedMethod("*"); // Allows all methods
        config.setAllowCredentials(true); // Allow credentials
        source.registerCorsConfiguration("/**", config); // Apply CORS configuration to all endpoints
        return new CorsFilter(source);
    }
}

