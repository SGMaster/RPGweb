package com.rpg.web.user.controller;

import com.rpg.web.user.model.User;

public class UserMapper {
 
	public static UserDto UserToUserDto(User user) {
		UserDto userDto = new UserDto(
				user.getId(),
				user.getName(),
				user.getNickname(),
				user.getPassword()
				);
		return userDto;
	}
	
}
