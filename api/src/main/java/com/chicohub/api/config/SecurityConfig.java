package com.chicohub.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // 1. Desabilita CSRF para permitir que o Postman envie dados (POST/PUT)
                .csrf(csrf -> csrf.disable())

                // 2. Configuração ÚNICA de autorização
                .authorizeHttpRequests(auth -> auth
                        // LIBERADO: Tudo que começa com /api/ está livre para o Postman
                        .requestMatchers("/api/**").permitAll() 
                        
                        // BLOQUEADO: Qualquer outra rota fora de /api/ exige login
                        .anyRequest().authenticated() 
                )

                // 3. Mantém a integração com Google OAuth2 ativa
                .oauth2Login(Customizer.withDefaults());

        return http.build();
    }
}