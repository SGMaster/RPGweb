package com.rpg.web.user.model;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long>, JpaSpecificationExecutor<User> {
	
	@Query("select user.nickname as nickname, user.password as password from User user "
			+ "where user.nickname = ?1")
	User finUserByNickname(String nickname);

}
