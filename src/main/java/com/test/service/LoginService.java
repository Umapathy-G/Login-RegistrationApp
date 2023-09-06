package com.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.Option;
import com.test.model.User;
import com.test.repo.OptionRepo;
import com.test.repo.UserRepo;

@Service
public class LoginService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	OptionRepo optionRepo;

	public void registerUser(User user) {
		user.setActive("Y");
		userRepo.save(user);
		System.out.println("User registered successfully..!!!");
	}

	public List<Option> getOptions() {
		return optionRepo.findAll();
	}

	public List<Option> getSelectedOption(String selectedOption) {
		List<Option> findByName = optionRepo.findByName(selectedOption);
		findByName.get(0).setActive("Y");
		return findByName;
	}
	
	public Optional<User> checkLoginUser(String email, String password) {
		return userRepo.findByEmailEqualsAndPasswordEquals(email, password);
	}
	
	public Optional<User> checkValidMailid(String email) {
		return userRepo.findByEmail(email);
	}
	
	public boolean updatePassword(User user) {
		return userRepo.save(user) != null;
	}
	
}
