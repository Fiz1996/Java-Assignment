package com.example.tree.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws  Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/api/v1/auth/*").permitAll()
                .antMatchers("/api/v1/statement/dateRange").hasRole("ADMIN")
                .antMatchers("/api/v1/statement/priceRange").hasRole("ADMIN")
                .requestMatchers()
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .maximumSessions(1)
                .and()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
