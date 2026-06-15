package com.example.login_baba;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())                              // autorise le POST du formulaire
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()); // ouvre toutes les pages
        return http.build();
    }
}
