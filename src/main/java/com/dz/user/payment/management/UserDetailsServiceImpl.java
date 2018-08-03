package com.dz.user.payment.management;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dz.user.payment.management.service.UserManagementSevice;
import com.dz.user.payment.management.value.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserManagementSevice userManagementService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userManagementService.getUser(username);
		GrantedAuthority auth = new SimpleGrantedAuthority(user.getLevel().toString());
		ArrayList<GrantedAuthority> auths = new ArrayList<>();
		auths.add(auth);
		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), auths);
	}

}
