package com.example.hotel_booking.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();

        return http.build();
    }
}

/*
 * @EnableWebSecurity
 * 
 * @EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true,
 * jsr250Enabled = true)
 * public class WebSecurityConfiguration {
 * 
 * // config
 * 
 * @Override
 * protected void configure(HttpSecurity http) throws Exception {
 * http.authorizeRequests()
 * .anyRequest()
 * .authenticated();
 * 
 * http.oauth2ResourceServer()
 * .jwt();
 * }
 * 
 * }
 */

/*
 * @EnableWebSecurity
 * 
 * @Configuration
 * public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
 * 
 * @Override
 * protected void configure(HttpSecurity http) throws Exception {
 * http.csrf().disable();
 * }
 * 
 * }
 */