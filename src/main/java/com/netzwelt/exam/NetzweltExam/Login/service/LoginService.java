package com.netzwelt.exam.NetzweltExam.Login.service;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {

	public boolean authenticateUser(String username, String password);
}
