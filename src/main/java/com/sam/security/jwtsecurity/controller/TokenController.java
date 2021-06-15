package com.sam.security.jwtsecurity.controller;

import com.sam.security.jwtsecurity.model.JwtUser;
import com.sam.security.jwtsecurity.security.JwtGenerator;
import com.sam.security.jwtsecurity.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenController {

	@Autowired
	private UserService userService;
	
	@Autowired
    private JwtGenerator jwtGenerator;
    
	@Autowired
    private BCryptPasswordEncoder encoder;
    

    @PostMapping("/login")
    public String generate(@RequestBody final JwtUser jwtUser) {
    	JwtUser user = userService.login(jwtUser);
    	if(user != null)
        return jwtGenerator.generate(user);
    	else
    		throw new UsernameNotFoundException("Given username or password is wrong");
    }
    
    @PostMapping("/signUp")
    public String singUp(@RequestBody final JwtUser jwtUser) {
    	jwtUser.setPassword(encoder.encode(jwtUser.getPassword()));
        return jwtGenerator.generate(userService.signUp(jwtUser));
    }
}
