package com.project.utsav.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.utsav.model.Event;

public interface EventRepo extends JpaRepository<Event, String> {

}
