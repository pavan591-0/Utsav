package com.project.utsav.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.utsav.model.Event;
import com.project.utsav.model.Registration;
import com.project.utsav.model.User;

@Repository
public interface RegistrationRepo extends JpaRepository<Registration, Long> {
	
	Optional<Registration> findByUserAndEvent(User user, Event event);

}
