package com.test.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.model.User;
import com.test.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;

	@GetMapping("/login")
	public String getLoginPage(Model model) {
		model.addAttribute("userData", new User());
		return "login";
	}

	@PostMapping("/loginUser")
	public String logInUser(@ModelAttribute("userData") User user, Model model) {
		Optional<User> checkLoginUser = loginService.checkLoginUser(user.getEmail(), user.getPassword());
		if (!checkLoginUser.isPresent()) {
			model.addAttribute("msg", "*Invalid Credentials");
			return "login";
		}
		User user1 = checkLoginUser.get();
		model.addAttribute("msg", user1.getName());
		return "dashboard";
	}
	
}
