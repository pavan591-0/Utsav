package com.project.utsav.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserProfile {

	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String phoneNumber;
	private LocalDateTime createdAt;
	
	public UserProfile() {
		super();
	}
	

	public UserProfile(String firstName, String lastName, String username, String email, String phoneNumber,
			LocalDateTime createdAt) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.createdAt = createdAt;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDate = createdAt.format(formatter);
		return "UserProfile [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", createdAt=" + formattedDate + "]";
	}

	
	

}
