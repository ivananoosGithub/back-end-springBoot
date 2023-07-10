package com.netzwelt.exam.NetzweltExam.Login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netzwelt.exam.NetzweltExam.Login.service.LoginService;
import com.netzwelt.exam.NetzweltExam.User.User;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/account")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody User user) {
		
        // Calling the login service to validate the user's credentials
        boolean isAuthenticated = loginService.authenticateUser(user.getUsername(), user.getPassword());
        
        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
	
}
