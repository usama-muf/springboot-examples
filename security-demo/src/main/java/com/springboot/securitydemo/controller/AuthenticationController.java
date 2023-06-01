package com.springboot.securitydemo.controller;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.securitydemo.entity.User;
import com.springboot.securitydemo.helper.AuthenticationRequest;
import com.springboot.securitydemo.helper.AuthenticationResponse;
import com.springboot.securitydemo.helper.RegisterRequest;
import com.springboot.securitydemo.repository.UserRepository;
import com.springboot.securitydemo.service.JwtService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	private final UserRepository userRepo;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	
	
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
		
		var user = User
				.builder()
				.firstname(request.getFirstname())
				.lastname(request.getLastname())
				.email(request.getEmail())
				.password(passwordEncoder.encode(request.getPassword()))
				.build();
		
		User savedUser = this.userRepo.save(user);
		String token=  jwtService.generateToken(savedUser);
		
		
//		return ResponseEntity.ok(new AuthenticationResponse(token));
		return ResponseEntity.ok(AuthenticationResponse.builder().token(token).build());
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
//				TODO
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		System.out.println("User emailId and password is correct ");
		
		User user = userRepo.findByEmail(request.getEmail()).orElseThrow(()-> new UsernameNotFoundException("Email id not found in DB"+request.getEmail()));
		var token = jwtService.generateToken(user);
		
		return ResponseEntity.ok(AuthenticationResponse.builder().token(token).build());
	}
	
	
}
