package com.project.utsav.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.utsav.model.User;
import com.project.utsav.repo.UserRepo;

@Service
public class AuthService {
	
	@Autowired
	private UserRepo userRepo;
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

	public User registerUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	public boolean registerAllUsers(List<User> users) {
	    users.forEach(user -> user.setPassword(encoder.encode(user.getPassword())));
	    List<User> savedUsers = userRepo.saveAll(users);
	    return savedUsers.size() == users.size();
	}

}
