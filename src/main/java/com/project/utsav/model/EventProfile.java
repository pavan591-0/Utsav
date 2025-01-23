package com.project.utsav.model;

import java.time.LocalDateTime;

public class EventProfile {
	
	private String eventId;
	private String name;
	private Integer guestCapacity;
	private String description;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	public EventProfile() {
		super();
	}
	
	public EventProfile(Event event) {
		this.eventId = event.getEventId();
		this.name = event.getName();
		this.description = event.getDescription();
		this.guestCapacity = event.getGuestCapacity();
		this.startTime = event.getStartTime();
		this.endTime = event.getEndTime();
	}
	
	public EventProfile(String name, Integer guestCapacity, String description, LocalDateTime startTime,
			LocalDateTime endTime) {
		super();
		this.name = name;
		this.guestCapacity = guestCapacity;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGuestCapacity() {
		return guestCapacity;
	}

	public void setGuestCapacity(Integer guestCapacity) {
		this.guestCapacity = guestCapacity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "EventProfile [name=" + name + ", guestCapacity=" + guestCapacity + ", description=" + description
				+ ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
	
	
	

}
