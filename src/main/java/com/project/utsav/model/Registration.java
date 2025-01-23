package com.project.utsav.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
public class Registration {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long registrationId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "event_id", nullable = false)
	private Event event;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@Column(nullable= false)
	private LocalDateTime registrationTime;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable= false)
	private RegistrationStatus registrationStaus;
	
	@PrePersist
	protected void onCreate() {
		this.registrationTime = LocalDateTime.now();
		this.registrationStaus = RegistrationStatus.PENDING;
	}

	public Registration() {
		super();
	}

	public Registration(Long registrationId, Event event, User user, LocalDateTime registrationTime,
			RegistrationStatus registrationStaus) {
		super();
		this.registrationId = registrationId;
		this.event = event;
		this.user = user;
		this.registrationTime = registrationTime;
		this.registrationStaus = registrationStaus;
	}

	public Registration(Event event, User user) {
		super();
		this.event = event;
		this.user = user;
	}

	public Long getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Long registrationId) {
		this.registrationId = registrationId;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(LocalDateTime registrationTime) {
		this.registrationTime = registrationTime;
	}

	public RegistrationStatus getRegistrationStaus() {
		return registrationStaus;
	}

	public void setRegistrationStaus(RegistrationStatus registrationStaus) {
		this.registrationStaus = registrationStaus;
	}

	@Override
	public String toString() {
		return "Registration [registrationId=" + registrationId + ", event=" + event + ", user=" + user
				+ ", registrationTime=" + registrationTime + ", registrationStaus=" + registrationStaus + "]";
	}
	
	
	

}
