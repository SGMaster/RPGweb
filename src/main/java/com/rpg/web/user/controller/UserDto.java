package com.rpg.web.user.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private Long id;
	
	private String name;
	
	private String nickname;
	
	private String password;
	
	private String email;

}
