package com.rpg.web.security.controller;

import java.util.Objects;

import com.rpg.web.user.model.User;

public class SecurityMapper {

	public static LoginInfoDto userToLoginInfoDto(User user) {
		if(Objects.isNull(user))
			return new LoginInfoDto();
		return LoginInfoDto.builder()
				.id(user.getId())
				.name(user.getName())
				.nickname(user.getNickname())
				.build();
	}
	
}
