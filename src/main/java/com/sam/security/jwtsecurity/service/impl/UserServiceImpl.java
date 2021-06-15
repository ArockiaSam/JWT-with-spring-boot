package com.sam.security.jwtsecurity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.sam.security.jwtsecurity.dao.UserDao;
import com.sam.security.jwtsecurity.model.JwtUser;
import com.sam.security.jwtsecurity.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	public JwtUser signUp(JwtUser jwtUser) {
		return userDao.save(jwtUser);
	}

	@Override
	public JwtUser login(JwtUser jwtUser) {
		JwtUser user = userDao.findByUserName(jwtUser.getUserName());
		if(user != null && BCrypt.checkpw(jwtUser.getPassword(), user.getPassword())) 
			return user;
		else
			return null;
	}
}
