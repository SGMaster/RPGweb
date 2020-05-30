package com.rpg.web.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/welcome")
	public String firstPage() {
		return "welcome to the RPG website";
	}
}
