package com.igor.car.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



public class UserSS implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String email;
	private String senha;
	private String funcao;
	private Collection<? extends GrantedAuthority> authorities;

	public UserSS(Integer id, String email, String senha, String funcao) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.funcao = funcao;
	}

	public Integer getId() {
		return id;
	}
	
	

	public String getFuncao() {
		return funcao;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
