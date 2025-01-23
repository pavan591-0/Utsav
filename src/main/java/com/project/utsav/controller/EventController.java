package com.project.utsav.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.project.utsav.exceptions.EventException;
import com.project.utsav.exceptions.UserException;
import com.project.utsav.model.EventProfile;
import com.project.utsav.service.EventService;

@RestController
@RequestMapping("/user/events")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@PostMapping("/create")
	public ResponseEntity<EventProfile> createEvent(@RequestBody EventProfile eventProfile, Principal principal) throws UserException, EventException {
		return ResponseEntity.status(HttpStatus.CREATED).body(eventService.createEvent(eventProfile, principal.getName()));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EventProfile> updateEvent(@PathVariable String id, @RequestBody EventProfile eventProfile, Principal principal) throws EventException{
		
		EventProfile updatedEvent = eventService.updateEvent(id, eventProfile, principal.getName());
		return ResponseEntity.ok(updatedEvent);
		
	}
	
	
}
