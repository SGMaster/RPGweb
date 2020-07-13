package com.rpg.web.user.controller;


public class UserDto {

	private Long id;
	
	private String name;
	
	private String nickname;
	
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDto(Long id, String name, String nickname, String password) {
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.password = password;
	}
	
	public UserDto() {
	
	}
}
