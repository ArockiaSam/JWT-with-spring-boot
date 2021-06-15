package com.sam.security.jwtsecurity.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JwtUserDetails implements UserDetails {

	private JwtUser jwtUser;
	
	
	
	/**
	 * @return the jwtUser
	 */
	public JwtUser getJwtUser() {
		return jwtUser;
	}

	/**
	 * @param jwtUser the jwtUser to set
	 */
	public void setJwtUser(JwtUser jwtUser) {
		this.jwtUser = jwtUser;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> grantedAuthority = new ArrayList<>();
		grantedAuthority.add(new SimpleGrantedAuthority("ROLE_"+jwtUser.getRole()));
		return grantedAuthority;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return jwtUser.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return jwtUser.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

    public JwtUserDetails(JwtUser jwtUser) {

        this.jwtUser = jwtUser;
    }
	
	
	//    private String userName;
//    private String token;
//    private Long id;
//    private Collection<? extends GrantedAuthority> authorities;
//
//
//    public JwtUserDetails(String userName, long id, String token, List<GrantedAuthority> grantedAuthorities) {
//
//        this.userName = userName;
//        this.id = id;
//        this.token= token;
//        this.authorities = grantedAuthorities;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return userName;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public String getToken() {
//        return token;
//    }
//
//
//    public Long getId() {
//        return id;
//    }

}
