package com.kris.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kris.demo.model.User;

@Service
public class LoginService {
	@Autowired
	private UserService service;

	public boolean validateUser(String email, String password) {
		
		
		boolean response=false;
	      for (User user : service.getUser()) {
	    	  
	    	  if(email==user.getEmail()&&password==user.getPassword()) {
	    		  
	    		 response=true;
	    	  }
	    	  else 
	    		  response=false;
	         
	        }
	     
		return response;
	}
	
}
