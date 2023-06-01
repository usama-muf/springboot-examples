package com.springboot.securitydemo.config;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.springboot.securitydemo.service.JwtService;

import io.micrometer.common.lang.NonNull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	private final JwtService jwtService;
	private final UserDetailsService userDetailsService;
	
	@Override
	protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain)
			throws ServletException, IOException {
		
		
//	1)	Check if we already have a JWT header 
		
		/*How ? we will look into the httpServletRequest  and search for Authorization*/
		
		final String authHeader = request.getHeader("Authorization");
		final String jwt;
		//extracting email from JWT token
		final String userEmail;
		
		if(authHeader == null || !authHeader.startsWith("Bearer ")) {
			// forward it to next filter chain
			System.out.println("Either authHeader is Null or authHeader not starts with Bearer");
			filterChain.doFilter(request, response);
			return;
			
		}
		
		jwt = authHeader.substring(7);
		userEmail = jwtService.extractUsername(jwt);
			
		if(userEmail != null || !userEmail.isBlank()||!userEmail.isEmpty() || !isUserAuthenticated()) {
			System.out.println("UserEmail is Not null nor blank nor empty AND user is Not Authenticated");
			
			// extracting UserDetails from emailId which was present in token.
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
			
			// checking token is still valid
			if(jwtService.isTokenValid(jwt, userDetails)) {

				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				//save the current user in securityContext for future uses.
				SecurityContextHolder.getContext().setAuthentication(authToken);
				//send request to dispatcherServlet	
			}
		}
		filterChain.doFilter(request, response);
	}
	
	private boolean isUserAuthenticated() {
		return SecurityContextHolder.getContext().getAuthentication() != null;
	}
	
	
	
	

}
