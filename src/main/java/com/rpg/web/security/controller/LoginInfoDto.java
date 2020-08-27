package com.rpg.web.security.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginInfoDto {
	
	private String name;
	private Long id;
	private String nickname;
	private String email;
	
}
