package com.security.encrypt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Permitir acceso a todas las URLs
                )
                .httpBasic(Customizer.withDefaults()) // (opcional) deshabilitar autenticación básica
                .formLogin(formLogin -> formLogin.disable()); // Deshabilitar formulario de inicio de sesión

        return http.build();
    }
}
