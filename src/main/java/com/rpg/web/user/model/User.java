package com.rpg.web.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
@Table(name="tb_user_user", schema="public")
public class User{
	
	@Id
	@Column(name = "id_user")
	private Long id;
	
	@Column(name = "st_user_name")
	private String name;
	
	@Column(name = "st_user_nickname")
	private String nickname;
	
	@Column(name = "st_user_password")
	private String password;

	public User(String username) {
		this.nickname=username;
	}
	
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

	public void setNickName(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return "dale";
	}

	public void setPassword(String password) {
		this.password = password;
	}	

	public User() {
		
	}

	public User(Long id, String name, String nickname, String password) {
		super();
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.password = password;
	}
	
	
	
}
