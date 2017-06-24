package com.bridgeLabz.Authentication.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.bridgeLabz.Authentication.model.UserData;

public class UserService {

	static Logger log = Logger.getLogger(UserService.class);
	
	public static List<UserData> userDatas = null;
	
	public static void addUser(){
		
		userDatas = new ArrayList<UserData>();
		
		userDatas.add(new UserData("ram", "123"));
		userDatas.add(new UserData("alkesh", "kalpesh"));
		
		
		log.warn("user added successfully");
	}
	
	
	public static boolean login(String userName, String password){
		
		Iterator<UserData> iterator = userDatas.iterator();
		
		while(iterator.hasNext()){
			
			UserData user = iterator.next();
			if(user.getUserName().equals(userName) && user.getPassword().equals(password)){
				
				log.warn("Uthenticatin Successfull");
				String accessToken = TokenService.generateToken(user);
				return true;
			}
			
		}
		log.warn("No users");
		return false;
	}
	
	
	
}
