package com.fatec.lab.eng.subme.dto;

import com.fatec.lab.eng.subme.entities.UserEntity;

public class SystemUserDTO extends UserDTO {
	private String username;
	private String password;

	public SystemUserDTO(){
	}

	public SystemUserDTO(UserEntity userEntity){
	this.setId(userEntity.getId());
	this.setName(userEntity.getName());
	this.setEmail(userEntity.getEmail());
	this.setUsername(userEntity.getUsername());
	this.setPassword(userEntity.getPassword());
	this.setCreatedAt(userEntity.getCreatedAt());
	this.setUpdatedAt(userEntity.getUpdatedAt());
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
