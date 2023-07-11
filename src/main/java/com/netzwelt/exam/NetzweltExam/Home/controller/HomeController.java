package com.netzwelt.exam.NetzweltExam.Home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netzwelt.exam.NetzweltExam.Home.service.HomeService;
import com.netzwelt.exam.NetzweltExam.Territory.Territory;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
    private HomeService homeService;

    @GetMapping("/index")
    public ResponseEntity<List<Territory>> getAllTerritories() {
        List<Territory> territories = homeService.getTerritoryHierarchy();
        return ResponseEntity.ok(territories);
    }
}

