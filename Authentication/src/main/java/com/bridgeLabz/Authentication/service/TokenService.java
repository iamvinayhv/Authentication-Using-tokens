package com.bridgeLabz.Authentication.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.bridgeLabz.Authentication.model.Token;
import com.bridgeLabz.Authentication.model.UserData;
import com.bridgeLabz.Authentication.model.UserToken;

public class TokenService {
	
	static Logger log = Logger.getLogger(TokenService.class);
	
	

	static Map<String, UserToken> userMap = new HashMap<String, UserToken>();
	
	static String acT =null;

	public static String generateToken(UserData user){
		
		String accessToken = UUID.randomUUID().toString().replaceAll("-", "");
		String refreshToken = UUID.randomUUID().toString().replaceAll("-", "");
		
		Token token = new Token();
		
		token.setAccessToken(accessToken);
		token.setRefreshToken(refreshToken);
		token.setUser(user);
		
		Properties prop = new Properties();
		InputStream input= null;
		try {
			
			
			input = new FileInputStream("/home/bridgeit/Vinay/WorkSpace/Authentication/Authentication/src/main/resources/token.properties");
			prop.load(input);
			token.setAccessExpireTime( new Date().getTime() + Long.parseLong(prop.getProperty("accessExpireTime")) );
			token.setRefreshExpireTime( new Date().getTime() + Long.parseLong(prop.getProperty("refreshExpireTime")) );
		
			
		} catch (IOException e) {
			
			log.warn("File not found");
			try {
				if( input != null)
					input.close();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		
		UserToken userToken = new UserToken();
		userToken.setToken(token);
		userToken.setUser(user);
		
		
		log.warn("accessToken------->"+accessToken);
		log.warn("userTOken--------->"+userToken.getUser().toString());
		log.warn("userTOken--------->"+userToken.getToken().toString());
		
		
		userMap.put(accessToken, userToken);
		
		log.warn("map---->"+userMap);
		
		//validateAccessToken(accessToken);
		acT= accessToken;
		
		return accessToken;
		
	}
	
	
	
	public static boolean validateAccessToken( String accessToken ){
		
	
		UserToken userToken = userMap.get(accessToken);
		
		if(userToken != null )
		{
			Token token = userToken.getToken();
			
			if( new Date().getTime() < token.getAccessExpireTime()){
				log.warn("valid ACCESS token");
				return true;
			}
			
			else if(  new Date().getTime() < token.getRefreshExpireTime() ){
				log.warn("valid REFRESH token");
				generateNewAccessToken(accessToken);
				return true;
			}
			
		}
		log.warn("INVALID ACCESS TOKEN");
		return false;
		
	}
	
	public static boolean generateNewAccessToken( String accessToken ){
		
		UserToken userToken = userMap.get(accessToken);
		
		Token token = userToken.getToken();
		UserData user = userToken.getUser();
		
		userMap.remove(accessToken);
		
		accessToken = UUID.randomUUID().toString().replaceAll("-", "");
		token.setAccessToken(accessToken);
		Properties prop = new Properties();
		token.setAccessExpireTime( new Date().getTime() + Long.parseLong(prop.getProperty("accessExpireTime")) );
		
		userToken.setToken(token);
		userToken.setUser(user);
		
		userMap.put(accessToken, userToken);
		return true;
	}
	
	
	
	

	
	

	
	
}
