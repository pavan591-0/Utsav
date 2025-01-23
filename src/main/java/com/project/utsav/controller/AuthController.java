package com.project.utsav.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.utsav.model.LoginRequest;
import com.project.utsav.model.User;
import com.project.utsav.service.AuthService;
import com.project.utsav.service.JwtService;

@RestController
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/register")
	public User registerUser(@RequestBody User user) {
		return authService.registerUser(user);
	}
	
	@PostMapping("/registerAll")
	public boolean registerAllUsers(@RequestBody List<User> users) {
		return authService.registerAllUsers(users);
	}

	@PostMapping("/login")
	public String login(@RequestBody LoginRequest user) {
		Authentication auth = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		if (auth.isAuthenticated()) {
			return jwtService.generateToken(user.getUsername());
		}
		return "failed";
	}

}
