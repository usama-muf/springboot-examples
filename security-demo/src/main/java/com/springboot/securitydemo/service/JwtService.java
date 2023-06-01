package com.springboot.securitydemo.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	private static final String SECRET_KEY = "68566D597133743677397A244326462948404D635166546A576E5A7234753778";

	public String extractUsername(String token) {
//		final Claims claims = extractAllClaims(token);
//		return claims.getSubject();
		return extractClaim(token, Claims::getSubject);
		
	}
	
	public boolean isTokenValid(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
	}
	
	public boolean isTokenExpired(String token) {
		return extractTokenExpiration(token).before(new Date());
		
	}

	private Date extractTokenExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	public String generateToken(UserDetails userDetails) {
		Map<String, Object> mp = new HashMap<>();
		return generateToken(mp, userDetails);
	}
	
	public String generateToken(Map<String, Object> extractClaims, UserDetails userDetails) {
		return Jwts
				.builder()
				.setClaims(extractClaims)
				.setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
				.signWith(getSignInKey(),SignatureAlgorithm.HS256)
				.compact();
	}
	
	private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
		final Claims claims = extractAllClaims(token);
		return claimResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(token).getBody();

	}

	private Key getSignInKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
		
	}

}
