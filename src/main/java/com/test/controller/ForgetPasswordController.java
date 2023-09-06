package com.test.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.model.ForgetPassword;
import com.test.model.User;
import com.test.service.LoginService;

import jakarta.validation.Valid;

@Controller
public class ForgetPasswordController {

	@Autowired
	LoginService loginService;

	@GetMapping("/passwordReset")
	public String getPasswordResetPage(ForgetPassword forget, Model model) {
		model.addAttribute("forgetUser", new ForgetPassword());
		return "forgetpassword";
	}

	@PostMapping("/resetPassword")
	public String resetPassword(@Valid @ModelAttribute("forgetUser") ForgetPassword forgetUser, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			return "forgetpassword";
		}
		Optional<User> checkValidMailid = loginService.checkValidMailid(forgetUser.getEmail());

		if (!checkValidMailid.isPresent()) {
			model.addAttribute("error", "*Email-id not registered");
			return "forgetpassword";
		}
		if (!forgetUser.getNewpassword().equals(forgetUser.getConfirmpassword())) {
			model.addAttribute("error", "*Password doesn't match");
			return "forgetpassword";
		}

		User user = checkValidMailid.get();
		user.setPassword(forgetUser.getConfirmpassword());
		loginService.updatePassword(user);

		return "redirect:/resetPasswordSuccess";
	}

	@GetMapping("/resetPasswordSuccess")
	public String resetPasswordSuccess(Model model) {
		model.addAttribute("forgetUser", new ForgetPassword());
		model.addAttribute("msg", "Password changed successfully..!!!");
		return "forgetpassword";
	}
}
