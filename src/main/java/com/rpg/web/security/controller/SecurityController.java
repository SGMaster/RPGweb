package com.rpg.web.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rpg.web.security.AuthenticationResponse;
import com.rpg.web.security.JwtUtil;
import com.rpg.web.security.Tokens;
import com.rpg.web.user.controller.UserDto;
import com.rpg.web.user.controller.UserMapper;
import com.rpg.web.user.model.User;
import com.rpg.web.user.service.UserService;

@RestController
public class SecurityController {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
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
		
		User user = userService.loadUserInfo(userDto.getNickname());
		user.setPassword(null);
		
		LoginInfoDto loginInfo = SecurityMapper.userToLoginInfoDto(user);
		
		final String token = jwtUtil.generateToken(userDetails);
		
		final Tokens tokens = new Tokens(token, token);

		return ResponseEntity.ok(new AuthenticationResponse(tokens, loginInfo));

	}
	
	@PostMapping("/registrar")
	public void registerNewUser(@RequestBody UserDto userDto) {
		User user = UserMapper.dtoToEntity(userDto);
		user.setPassword(this.passwordEncoder.encode(userDto.getPassword()));
		userService.create(user);
	}

}
