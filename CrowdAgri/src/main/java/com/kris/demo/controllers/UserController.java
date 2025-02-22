package com.kris.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kris.demo.model.User;
import com.kris.demo.service.UserService;

@RestController

public class UserController {
	
	@Autowired
	private UserService service;
	
	//A redefinir
	public void login() {}
	public void signup() {}
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return service.saveUser(user);
		
	}
	@GetMapping("/user")
	public List<User> findAllUser(){
		return service.getUser();
	}
	@GetMapping("/user/{id}")
	public User findUserById(@PathVariable Integer id) {
		return service.getUserById(id);
	}
	
	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {
		return service.updateUser(user);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable Integer id) {
	return service.deleteUser(id);
	}
	
}
