package com.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Option {

	@Id
	private Integer id;
	private String name;
	private String active;

	public Option() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Option(Integer id, String name, String active) {
		super();
		this.id = id;
		this.name = name;
		this.active = active;
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

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

}
