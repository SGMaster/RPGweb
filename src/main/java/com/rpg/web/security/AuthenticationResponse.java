package com.rpg.web.security;

import com.rpg.web.security.controller.LoginInfoDto;
import com.rpg.web.user.model.User;

public class AuthenticationResponse {

	private Tokens tokens;
	private LoginInfoDto userInfo;
	
	public AuthenticationResponse() {
		
	}
	
	public AuthenticationResponse(Tokens tokens, LoginInfoDto userInfo) {
		this.tokens = tokens;
		this.userInfo = userInfo;
	}
	
	public Tokens getTokens() {
		return tokens;
	}
	
	public LoginInfoDto getUserInfo() {
		return userInfo;
	}
		
}
