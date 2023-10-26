package com.ty.hrms.security.filter;

import java.io.IOException;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ty.hrms.util.JwtsUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class SecurityFilter extends OncePerRequestFilter {

	private final JwtsUtils jwtsUtils;
	private final UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String bearerToken = request.getHeader("Authorization");

		if (bearerToken != null && bearerToken.startsWith("Bearer ")) {

			String token = bearerToken.substring(7);

			String usernameFromToken = jwtsUtils.getUsername(token);

			UserDetails userFromDB = userDetailsService.loadUserByUsername(usernameFromToken);

			if (token != null && userFromDB.getUsername() != null
					&& SecurityContextHolder.getContext().getAuthentication() == null) {

				if (jwtsUtils.isValidToken(token, userFromDB.getUsername())) {

					UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
							userFromDB.getUsername(), userFromDB.getPassword(), userFromDB.getAuthorities());

					authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				}
			}
		}
		filterChain.doFilter(request, response);
	}

}
