package com.netzwelt.exam.NetzweltExam.SecurityConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/account/login").permitAll() // Allow access to the login page
                .antMatchers("/account/**").authenticated() // Require authentication for other endpoints under /account
                .anyRequest().permitAll()
                .and()
            .formLogin()
                .loginPage("/account/login") // Set the login page URL
                .defaultSuccessUrl("/home/index") // Set the default URL to redirect after successful login
                .permitAll()
                .and()
            .logout()
                .logoutUrl("/account/logout") // Set the logout URL
                .logoutSuccessUrl("/account/login") // Set the URL to redirect after successful logout
                .permitAll();
    }
}

