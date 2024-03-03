/*package com.laioffer.secondhandmarketapp02292024_1.config;

import com.google.cloud.storage.HttpMethod;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Apply CORS configurations
                .cors(corsCustomizer -> {
                    // Customize your CORS configuration here
                    corsCustomizer.configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
                })
                // Disable CSRF protection as it's not needed for API
                .csrf(csrfCustomizer -> csrfCustomizer.disable())
                // Permit all OPTIONS requests
                .authorizeHttpRequests(authzCustomizer -> authzCustomizer
                        .requestMatchers(String.valueOf(HttpMethod.OPTIONS)).permitAll()  // Permit all OPTIONS requests
                        .anyRequest().authenticated()  // Other requests need to be authenticated
                );

        return http.build();
    }
}

*/