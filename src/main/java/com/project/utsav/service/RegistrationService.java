package com.project.utsav.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.utsav.exceptions.RegistrationException;
import com.project.utsav.exceptions.UserException;
import com.project.utsav.model.Event;
import com.project.utsav.model.Registration;
import com.project.utsav.model.RegistrationDto;
import com.project.utsav.model.RegistrationStatus;
import com.project.utsav.model.User;
import com.project.utsav.repo.EventRepo;
import com.project.utsav.repo.RegistrationRepo;
import com.project.utsav.repo.UserRepo;

@Service
public class RegistrationService {

	@Autowired
	private EventRepo eventRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RegistrationRepo registrationRepo;
	
	public RegistrationDto getRegistered(String id, String username) throws RegistrationException, UserException {
		
		User user = userRepo.findByUsername(username)
				.orElseThrow(() -> new UserException(username+ " not found in the databse!"));
		Event event = eventRepo.findById(id)
						.orElseThrow(() -> new RegistrationException("Registration Error: No such event exists!"));
		if(registrationRepo.findByUserAndEvent(user, event).isPresent()) {
			throw new RegistrationException("User already registered for the event");
		}
		
		Registration registration = new Registration(event, user);
		registration = registrationRepo.save(registration);
		
		return new RegistrationDto(registration);
		
		
	}

	public RegistrationStatus getStatus(Long id) throws RegistrationException {
		return registrationRepo.findById(id)
				.orElseThrow(() -> new RegistrationException("Not Registered!"))
				.getRegistrationStaus();
	}

}
