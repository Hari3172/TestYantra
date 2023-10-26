package com.ty.hrms.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ty.hrms.security.filter.SecurityFilter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final PasswordEncoder passwordEncoder;
	private final UserDetailsService userDetailsService;
	private final SecurityFilter securityFilter;

	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable());
		log.warn("CSRF : csrf.disable()");

		http.authorizeRequests(requests -> requests.antMatchers("/api/employees/**").hasAnyRole("EMPLOYEE", "ADMIN"));
		http.authorizeRequests(requests -> requests.antMatchers("/api/skills/**").hasAnyRole("EMPLOYEE", "ADMIN"));
		http.authorizeRequests(requests -> requests.antMatchers("/api/programs/**").hasAnyRole("EMPLOYEE", "ADMIN"));
		http.authorizeRequests(
				requests -> requests.antMatchers("/api/auth/**").permitAll().anyRequest().authenticated());
		http.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
	}
}






