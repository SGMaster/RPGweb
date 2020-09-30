package com.rpg.web.user.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rpg.web.user.model.MyUserDetails;
import com.rpg.web.user.model.User;
import com.rpg.web.user.model.UserRepository;


@Service
public class UserService implements UserDetailsService {

	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User verifyUser(String nickname, String password) {
		return userRepository.findUserByNickname(nickname);
		
	}
	
	public List<User> seeUser() {
		return (List<User>) userRepository.findAll();
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findUserByNickname(username);


		return new MyUserDetails(user.getNickname(), user.getPassword());
	}
	
	public User loadUserInfo(String username) throws UsernameNotFoundException {
		return userRepository.findUserByNickname(username);

	}
	
	public void create(User user) {
		User existUserEmail = userRepository.findUserByEmail(user.getEmail());
		User existUserNickname = userRepository.findUserByNickname(user.getNickname());
		if(!Objects.isNull(existUserNickname))
			throw new IllegalArgumentException("Apelido já existe");
		
		if(!Objects.isNull(existUserEmail))
			throw new IllegalArgumentException("Email já cadastrado");
			
		this.userRepository.save(user);
	}
}
