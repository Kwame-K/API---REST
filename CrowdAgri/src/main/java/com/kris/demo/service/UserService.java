package com.kris.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kris.demo.model.User;
import com.kris.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User saveUser(User user) {
		return repository.save(user);
	}
	
	public List<User> getUser(){
		return repository.findAll();
	}
public User getUserById(Integer id){
	return repository.findById(id).orElse(null);
}

public String deleteUser(Integer id) {
	repository.deleteById(id);
	return "Utilisateur "+id+ " supprimé ";
}


public User updateUser(User user) {
	User existingUser=repository.findById(user.getId()).orElse(null);
	existingUser.setEmail(user.getEmail());
	existingUser.setPassword(user.getPassword());
	return repository.save(existingUser);
	
}



}
