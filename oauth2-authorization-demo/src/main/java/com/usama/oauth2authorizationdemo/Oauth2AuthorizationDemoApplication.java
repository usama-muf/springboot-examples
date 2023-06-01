package com.usama.oauth2authorizationdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.client.oidc.authentication.OidcAuthorizationCodeAuthenticationProvider;

@SpringBootApplication
public class Oauth2AuthorizationDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2AuthorizationDemoApplication.class, args);
	}
}