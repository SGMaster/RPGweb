package com.rpg.web.user.model;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

@SuppressWarnings("serial")
public class UserSpecification {
	
	public static final Specification<User> equalNickname(String nickname){
		return new Specification<User>() {
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				if(nickname == null) {
					return null;
				}
				return builder.equal(root.get("nickname"), nickname);
			}
		};
	}
	
}
