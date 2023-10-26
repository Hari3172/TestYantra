package com.ty.hrms.security.service;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ty.hrms.entity.AppUser;
import com.ty.hrms.repository.AppUserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final AppUserRepository appUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		AppUser user = appUserRepository.findById(username).orElseThrow(
				() -> new UsernameNotFoundException("The user with username " + username + " does not exist!!"));

		return new User(username, user.getPassword(), user.getRoles().stream()
				.map(r -> new SimpleGrantedAuthority(r.getRoleName())).collect(Collectors.toList()));
	}

}
