package com.fatec.lab.eng.subme.dto;

public class AuthorizationDTO {
	private String token;

	public AuthorizationDTO(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
