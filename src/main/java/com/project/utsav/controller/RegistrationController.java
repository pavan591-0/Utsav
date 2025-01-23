package com.project.utsav.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.utsav.exceptions.RegistrationException;
import com.project.utsav.exceptions.UserException;
import com.project.utsav.model.RegistrationDto;
import com.project.utsav.model.RegistrationStatus;
import com.project.utsav.service.RegistrationService;

@RestController
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@PostMapping("/{id}")
	public ResponseEntity<RegistrationDto> getRegistered(@PathVariable String id, Principal principal) 
			throws RegistrationException, UserException{
		return ResponseEntity.status(HttpStatus.CREATED).body(registrationService.getRegistered(id, principal.getName()));
	}
	
	@GetMapping("/status/{id}")
	public ResponseEntity<RegistrationStatus> getStatus(@PathVariable Long id) throws RegistrationException{
		return ResponseEntity.status(HttpStatus.FOUND).body(registrationService.getStatus(id));
	}
	
}
