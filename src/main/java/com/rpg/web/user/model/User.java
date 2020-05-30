package com.rpg.web.user.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tb_user_user")
public class User {
	
	@Id
	@Column(name = "id_user")
	private Long id;
	
	@Column(name = "st_user_name")
	private String name;
	
	@Column(name = "st_user_nickName")
	private String nickName;
	
	@Column(name = "st_user_password")
	private String password;

}
