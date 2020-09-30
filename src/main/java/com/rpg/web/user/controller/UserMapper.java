package com.rpg.web.user.controller;

import java.util.Objects;

import com.rpg.web.user.model.User;

public class UserMapper {
 
	public static UserDto UserToUserDto(User user) {
		if(Objects.isNull(user))
			return new UserDto();
		return UserDto.builder()
				.id(user.getId())
				.name(user.getName())
				.nickname(user.getNickname())
				.password(user.getPassword())
				.email(user.getEmail())
				.build();
	}
	
	public static User dtoToEntity(UserDto dto) {
		if(Objects.isNull(dto))
			return new User();
		return User.builder()
				.id(dto.getId())
				.name(dto.getName())
				.nickname(dto.getNickname())
				.password(dto.getPassword())
				.email(dto.getEmail())
				.build();
	}
	
}
