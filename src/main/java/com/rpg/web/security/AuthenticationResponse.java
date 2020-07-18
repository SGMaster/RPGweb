package com.rpg.web.security;

public class AuthenticationResponse {

	private String token;
	private String refreshToken;
	
	public AuthenticationResponse() {
		
	}
	
	public AuthenticationResponse(String token, String refreshToken) {
		this.token = token;
		this.refreshToken = refreshToken;
	}
	
	public String getToken() {
		return token;
	}
		
	public String getRefreshToken() {
		return refreshToken;
	}
	
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
}
