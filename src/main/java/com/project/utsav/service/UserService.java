package com.project.utsav.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.utsav.exceptions.UserException;
import com.project.utsav.model.User;
import com.project.utsav.model.UserProfile;
import com.project.utsav.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public UserProfile getUserProfile(String username) throws UserException {
		User user = userRepo.findByUsername(username)
				.orElseThrow(() -> new UserException("User "+ username + " is not found in the database."));
		return new UserProfile(
				user.getFirstName(),
				user.getLastName(),
				user.getUsername(),
				user.getEmail(),
				user.getPhoneNumber(),
				user.getCreatedAt()
				);
	}

}
