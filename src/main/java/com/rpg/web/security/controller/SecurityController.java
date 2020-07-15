package com.rpg.web.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rpg.web.security.AuthenticationResponse;
import com.rpg.web.security.JwtUtil;
import com.rpg.web.user.controller.UserDto;
import com.rpg.web.user.service.UserService;

@RestController
public class SecurityController {

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/autenticar")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody UserDto userDto) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(userDto.getNickname(), userDto.getPassword()));
		} 
		catch (BadCredentialsException e) {
			throw new Exception("Apelido ou senha incorretos", e);
		}

		final UserDetails userDetails = userService.loadUserByUsername(userDto.getNickname());

		final String token = jwtUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(token));

	}

}
