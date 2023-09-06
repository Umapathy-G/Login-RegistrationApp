package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.model.Option;
import com.test.model.User;
import com.test.service.LoginService;

import jakarta.validation.Valid;

@Controller
public class RegisterController {
	
	@Autowired
	LoginService loginService;

	@GetMapping("/register")
	public String getRegisterationPage(Model model) {
		List<Option> options = loginService.getOptions();
		model.addAttribute("userData", new User());
		model.addAttribute("options", options);
		return "register";
	}

	@PostMapping("/registerUser")
	public String registerUser(Model model, @Valid @ModelAttribute("userData") User user, BindingResult result) {
		if(result.hasErrors()) {
			List<Option> options = loginService.getOptions();
			model.addAttribute("options", options);
			return "register";
		}
		loginService.registerUser(user);		
		return "redirect:/registerUserSuccess";
	}
	
	@GetMapping("/registerUserSuccess")
	public String registerUserSuccess(Model model) {
		List<Option> options = loginService.getOptions();
		model.addAttribute("msg", "User Registered Successfully..!!");
		model.addAttribute("userData", new User());
		model.addAttribute("options", options);
		return "register";
	}
}
