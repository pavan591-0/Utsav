package com.project.utsav.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.utsav.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>, CrudRepository<User, Integer> {
	Optional<User> findByUsername(String username);
}
