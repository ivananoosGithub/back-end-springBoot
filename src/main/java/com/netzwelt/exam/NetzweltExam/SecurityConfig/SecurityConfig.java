//package com.netzwelt.exam.NetzweltExam.SecurityConfig;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
////    @Autowired
////    private CustomAuthenticationProvider authenticationProvider;
////
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.authenticationProvider(authenticationProvider);
////    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//                .antMatchers("/account/login").permitAll() // Allow access to the login page
//                .antMatchers("/home/index").authenticated() // Require authentication for the home page
//                .anyRequest().permitAll() // Allow access to any other request
//                .and()
//            .formLogin()
//                .loginPage("/account/login") // Set the login page URL
//                .defaultSuccessUrl("/home/index") // Set the default URL to redirect after successful login
//                .permitAll()
//                .and()
//            .logout()
//                .logoutUrl("/account/logout") // Set the logout URL
//                .logoutSuccessUrl("/account/login") // Set the URL to redirect after successful logout
//                .permitAll()
//                .and()
//            .csrf().disable(); // Disable CSRF protection for simplicity (you may enable it in a production environment)
//    }
//}
