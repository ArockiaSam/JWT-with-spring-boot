package com.sam.security.jwtsecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sam.security.jwtsecurity.model.JwtUser;

public interface UserDao extends JpaRepository<JwtUser, Long>{

	public JwtUser findByUserName(String userName);
}
