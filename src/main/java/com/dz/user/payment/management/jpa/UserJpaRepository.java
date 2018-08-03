package com.dz.user.payment.management.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dz.user.payment.management.value.User;

public interface UserJpaRepository extends JpaRepository<User, Long> {

	public User findByName(String name);
	
}
