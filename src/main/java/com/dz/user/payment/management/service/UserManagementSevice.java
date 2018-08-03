package com.dz.user.payment.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dz.user.payment.management.jpa.UserJpaRepository;
import com.dz.user.payment.management.value.User;
import com.dz.user.payment.management.value.UserLevel;

@Service
public class UserManagementSevice {

	@Autowired
	UserJpaRepository userJpaRepo;
	
	@Transactional
	public User createUser(String username, String password) throws Exception {
		try {
			User user = new User(0, username, new BCryptPasswordEncoder().encode(password), UserLevel.USER);
			return userJpaRepo.saveAndFlush(user);
		} catch (DataAccessException e) {
			throw new Exception("User Already exists", e);
		}
	}
	
	public User getUser(String username) {
		return userJpaRepo.findByName(username);
	}
}
