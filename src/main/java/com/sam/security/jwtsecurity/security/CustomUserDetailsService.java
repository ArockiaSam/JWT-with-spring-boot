package com.sam.security.jwtsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sam.security.jwtsecurity.dao.UserDao;
import com.sam.security.jwtsecurity.model.JwtUser;
import com.sam.security.jwtsecurity.model.JwtUserDetails;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		JwtUser jwtUser = userDao.findByUserName(username);
		if(jwtUser != null) {
			return new JwtUserDetails(jwtUser);
		}else {
			throw new UsernameNotFoundException("Given username: "+username+" is not available in the memory");
		}
	}

}
