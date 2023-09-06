package com.test.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ForgetPassword {
	
	@NotEmpty(message = "*Email required")
	@Email(message = "*Invalid email")
	private String email;
	
	@NotEmpty(message = "*Password required")
	@Size(min=6,message="*Min 6 characters required")
	private String newpassword;
	
	@NotEmpty(message = "*Password required")
	@Size(min=6,message="*Min 6 characters required")
	private String confirmpassword;

	public ForgetPassword() {
		super();
	}

	public ForgetPassword(String email, String newpassword, String confirmpassword) {
		super();
		this.email = email;
		this.newpassword = newpassword;
		this.confirmpassword = confirmpassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

}
