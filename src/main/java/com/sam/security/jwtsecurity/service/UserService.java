package com.sam.security.jwtsecurity.service;

import com.sam.security.jwtsecurity.model.JwtUser;

public interface UserService {

	public JwtUser signUp(JwtUser jwtUser);
	
	public JwtUser login(JwtUser jwtUser);
	
}
