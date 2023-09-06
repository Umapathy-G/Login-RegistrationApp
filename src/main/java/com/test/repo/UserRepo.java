package com.test.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	public Optional<User> findByEmailEqualsAndPasswordEquals(String name, String password);
	
	public Optional<User> findByEmail(String email);
}
