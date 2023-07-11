package com.netzwelt.exam.NetzweltExam.Home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netzwelt.exam.NetzweltExam.Home.service.HomeService;
import com.netzwelt.exam.NetzweltExam.User.User;


@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
	@GetMapping(value = "/index")
    public ResponseEntity<String> login(@RequestBody User user) {
		
    }

}
