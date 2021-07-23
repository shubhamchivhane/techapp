package com.jarvis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jarvis.model.User;
import com.jarvis.service.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl service;
	
	@GetMapping("/")
	public String showIndex()
	{
		return "this is string";
	}
	
	@PostMapping("/saveUser")
	public User addUser(@RequestBody User user)
	{
		user.setActive(true);
		User u=null;
		try {
			u=service.saveUser(user);
		} catch (Exception e) {
		 u=null;
		 System.out.println(e.getMessage()+"  "+e.getCause());
		}
		return u;
	}
	
	@GetMapping("/activateUser/{id}")
	public User addUser(@PathVariable("id") int id)
	{
		System.out.println("id is :"+id);
		User u;
		try {
			u = service.activateUser(id);
		} catch (Exception e) {
			u=null;
			System.out.println(e.getMessage());
		}
		return u;
	}
	
}
