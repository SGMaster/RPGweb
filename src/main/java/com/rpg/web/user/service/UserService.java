package com.rpg.web.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpg.web.user.model.User;
import com.rpg.web.user.model.UserRepository;
import com.rpg.web.user.model.UserSpecification;


@Service
public class UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public boolean verifyUser(String nickname, String password) {
		List<User> user = userRepository.findAll(
				UserSpecification.equalNickname(nickname)
				);
		for(User u: user) {
			if(u.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
		
	}
	
	public List<User> seeUser() {
		return (List<User>) userRepository.findAll();
		
	}
	
}
