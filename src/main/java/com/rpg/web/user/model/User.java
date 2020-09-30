package com.rpg.web.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
@Table(name="tb_user_user", schema="public")
@SequenceGenerator(name = "sq_user", initialValue = 1, allocationSize = 1)
public class User{
	
	@Id
	@GeneratedValue(generator = "sq_user", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_user")
	private Long id;
	
	@Column(name = "st_user_name")
	private String name;
	
	@Column(name = "st_user_nickname")
	private String nickname;
	
	@Column(name = "st_user_password")
	private String password;

	@Column(name = "st_user_email")
	private String email;	
	
	
}
