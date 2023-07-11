package com.netzwelt.exam.NetzweltExam.Login.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginServiceImpl implements LoginService {

	@Override
	public boolean authenticateUser(String username, String password) {
	    try {
	        // Made a request to the external API to authenticate the user
	        RestTemplate restTemplate = new RestTemplate();
	        String url = "https://netzwelt-devtest.azurewebsites.net/Account/SignIn";
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        Map<String, String> requestBody = new HashMap<>();
	        requestBody.put("username", username);
	        requestBody.put("password", password);
	        HttpEntity<Map<String, String>> request = new HttpEntity<>(requestBody, headers);
	        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

	        // Check the response and return true or false based on the authentication result
	        if (response.getStatusCode() == HttpStatus.OK) {
	            return true; // User authenticated successfully
	        } else {
	            return false; // Authentication failed
	        }

	    } catch (Exception e) {
	        // Handle any exceptions that occur during the API request
	        e.printStackTrace();
	        return false; // Return false to indicate authentication failure
	    }
	}


}
