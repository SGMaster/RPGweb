package com.rpg.web.user.model;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long>, JpaSpecificationExecutor<User> {
	
	@Query("select user from User user "
			+ "where user.nickname = ?1")
	User findUserByNickname(String nickname);

	@Query("select user from User user "
			+ "where user.email = ?1")
	User findUserByEmail(String email);
	
}
