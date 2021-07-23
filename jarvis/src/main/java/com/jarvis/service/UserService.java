package com.jarvis.service;

import java.util.List;

import com.jarvis.model.User;

public interface UserService {
	
	
	public User saveUser(User user);
	
	public User getUserById(int id);
	
	public User activateUser(int id);
	
	public List<User> getAllUser();
	
	

}
