package com.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "User_Table")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "*Name required")
	@Size(min=3, max=10,message="*Min 4 and Max 10 characters allowed")
	private String name;

	@NotEmpty(message = "*Email required")
	@Email(message = "*Invalid email")
	private String email;

	@NotEmpty(message = "*Password required")
	@Size(min=6, message="*Min. 6 characters!")
	private String password;

	@NotNull(message = "*Gender required")
	private String selectedOption;

	private String active;

	public User() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getSelectedOption() {
		return selectedOption;
	}

	public void setSelectedOption(String selectedOption) {
		this.selectedOption = selectedOption;
	}

	public User(String name, String email, String password, String selectedOption, String active) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.selectedOption = selectedOption;
		this.active = active;
	}

}
