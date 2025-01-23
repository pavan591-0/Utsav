package com.project.utsav.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String firstName;

	    @Column(nullable = false)
	    private String lastName;

	    @Column(nullable = false, unique = true)
	    private String username; 

	    @Column(nullable = false, unique = true)
	    private String email;

	    @Column(nullable = false)
	    private String password; 

	    @Column(nullable = false, unique = true)
	    private String phoneNumber;

	    @Column(nullable = false, updatable = false)
	    private LocalDateTime createdAt = LocalDateTime.now();
	    
	    public User() {
	    	super();
	    }

		public User(String firstName, String lastName, String username, String email, String password,
				String phoneNumber) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.username = username;
			this.email = email;
			this.password = password;
			this.phoneNumber = phoneNumber;
		}



		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
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
			return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
					+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", createdAt="
					+ createdAt + "]";
		}
	    
	    


}
