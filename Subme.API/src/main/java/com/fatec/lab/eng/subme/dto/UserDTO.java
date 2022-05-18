package com.fatec.lab.eng.subme.dto;

public class UserDTO extends RegisterDTO {
	private String email;
	private String name;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
