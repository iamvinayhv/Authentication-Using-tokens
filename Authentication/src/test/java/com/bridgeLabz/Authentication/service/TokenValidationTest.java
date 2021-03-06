package com.bridgeLabz.Authentication.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class TokenValidationTest {

	@Test
	public void validateToken() {
		
		UserService.addUser();
		
		UserService.login("ram", "123");
		
		assertEquals(true, TokenService.validateAccessToken(TokenService.acT));
	}
	
	@Test
	public void InvalidToken() {
		
		UserService.addUser();
		
		assertEquals(true, UserService.login("ram", "123"));
		
		assertEquals(false, TokenService.validateAccessToken(TokenService.acT+"fff"));
	}

}
