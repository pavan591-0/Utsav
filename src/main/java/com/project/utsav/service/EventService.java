package com.project.utsav.service;

import java.security.Principal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.utsav.exceptions.EventException;
import com.project.utsav.exceptions.UserException;
import com.project.utsav.model.Event;
import com.project.utsav.model.EventProfile;
import com.project.utsav.model.User;
import com.project.utsav.repo.EventRepo;
import com.project.utsav.repo.UserRepo;

@Service
public class EventService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private EventRepo eventRepo;
	
	private void timeDiff(LocalDateTime startTime, LocalDateTime endTime) throws EventException {
		if(startTime.isAfter(endTime)) 
			throw new EventException("Start time cannot be after End time. Please adjust!!!");
	}

	public EventProfile createEvent(EventProfile eventProfile, String username) throws UserException, EventException {
		
		User user = userRepo.findByUsername(username).
				orElseThrow(() -> new UserException("User "+ username + " is not found in the database."));
		
		timeDiff(eventProfile.getStartTime(), eventProfile.getEndTime());
		
		Event event = new Event(eventProfile.getName(), eventProfile.getGuestCapacity(), eventProfile.getDescription(),
				eventProfile.getStartTime(), eventProfile.getEndTime(), user);
		
		event = eventRepo.save(event);
		
		return new EventProfile(event);
	}


	public EventProfile updateEvent(String id, EventProfile eventProfile, String username) throws EventException {
		Event event = eventRepo.findById(id)
				.orElseThrow(() -> new EventException("No such event exists in the database."));
		
		if(! event.getCreatedBy().getUsername().equals(username)) {
			throw new EventException(username+ "  do not have the permission to modify the event");
		}
		
		timeDiff(eventProfile.getStartTime(), eventProfile.getEndTime());
		
		event.setName(eventProfile.getName());
        event.setDescription(eventProfile.getDescription());
        event.setStartTime(eventProfile.getStartTime());
        event.setEndTime(eventProfile.getEndTime());
        event.setGuestCapacity(eventProfile.getGuestCapacity());
		
		EventProfile updatedProfile = new EventProfile(eventRepo.save(event));
		
		return updatedProfile;
		
	}

}
