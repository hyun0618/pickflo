package com.pickflo.dto;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.pickflo.domain.User;

import lombok.Data;

@Data
public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	private User user;
	
	public CustomUserDetails (User user) {
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.emptyList();
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}
	
	public String getNickname() {
		return user.getNickname();
	}
	
	public Long getId() {
		return user.getId();
	}
	
	public String getUserRole() {
		return user.getUserRole();
	}
	
}