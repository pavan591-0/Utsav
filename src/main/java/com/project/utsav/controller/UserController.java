package com.project.utsav.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.utsav.exceptions.UserException;
import com.project.utsav.model.UserProfile;
import com.project.utsav.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/profile")
	public ResponseEntity<UserProfile> retreiveProfile(Principal principal) throws UserException {
		String username = principal.getName();
		UserProfile profile = userService.getUserProfile(username);
		return ResponseEntity.ok(profile);
	}
}
