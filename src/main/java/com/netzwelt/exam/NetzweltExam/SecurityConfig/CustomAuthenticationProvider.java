//package com.netzwelt.exam.NetzweltExam.SecurityConfig;
//
//import com.netzwelt.exam.NetzweltExam.Login.service.LoginService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CustomAuthenticationProvider implements AuthenticationProvider {
//
//    @Autowired
//    private LoginService loginService;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String username = "foo";
//        String password = "bar";
//
//        boolean isAuthenticated = loginService.authenticateUser(username, password);
//
//        if (isAuthenticated) {
//            return new UsernamePasswordAuthenticationToken(username, password);
//        } else {
//            throw new BadCredentialsException("Invalid username or password");
//        }
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return authentication.equals(UsernamePasswordAuthenticationToken.class);
//    }
//}
