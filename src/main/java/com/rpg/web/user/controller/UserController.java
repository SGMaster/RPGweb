package com.rpg.web.user.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rpg.web.user.model.User;
import com.rpg.web.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/login/v1")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/login")
	public boolean firstPage(@RequestBody UserDto userDto) {
		return userService.verifyUser(userDto.getNickname(), userDto.getPassword());
	}
	
	@GetMapping("/see")
	public List<UserDto> seeUsers() {
		List<User> list = userService.seeUser();
		return list.stream().map(UserMapper::UserToUserDto).collect(Collectors.toList());
	}
}
