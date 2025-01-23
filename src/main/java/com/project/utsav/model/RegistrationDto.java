package com.project.utsav.model;

import java.time.LocalDateTime;

public class RegistrationDto {
	
	private Long registration_id;
	private LocalDateTime registrationTime;
	private RegistrationStatus registrationStatus;
	
	public RegistrationDto(Long registration_id, LocalDateTime registrationTime,
			RegistrationStatus registrationStatus) {
		super();
		this.registration_id = registration_id;
		this.registrationTime = registrationTime;
		this.registrationStatus = registrationStatus;
	}
	public RegistrationDto(Registration registration) {
		this.registration_id = registration.getRegistrationId();
		this.registrationTime = registration.getRegistrationTime();
		this.registrationStatus = registration.getRegistrationStaus();
	}
	public Long getRegistration_id() {
		return registration_id;
	}
	public void setRegistration_id(Long registration_id) {
		this.registration_id = registration_id;
	}
	
	public LocalDateTime getRegistrationTime() {
		return registrationTime;
	}
	public void setRegistrationTime(LocalDateTime registrationTime) {
		this.registrationTime = registrationTime;
	}
	public RegistrationStatus getRegistrationStatus() {
		return registrationStatus;
	}
	public void setRegistrationStatus(RegistrationStatus registrationStatus) {
		this.registrationStatus = registrationStatus;
	} 
	
	
	

}
