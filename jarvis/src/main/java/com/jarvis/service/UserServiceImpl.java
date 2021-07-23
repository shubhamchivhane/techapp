package com.jarvis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.dao.UserRepository;
import com.jarvis.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repo;
	
	@Override
	public User saveUser(User user) {
		
		return repo.save(user);
	}

	@Override
	public User getUserById(int id) {
		Optional<User> opt = repo.findById(id);
		System.out.println("value of u"+opt.get());
		 return opt.get();
	}

	@Override
	public User activateUser(int id) {
		 System.out.println("UserServiceImpl "+id);
		User u=getUserById(id);
		 System.out.println("UserServiceImpl user  :"+u);
		if(u.getActive())
		{
			u.setActive(false);
			System.out.println("print user :"+u);
			saveUser(u);
					}else
					{
						System.out.println("heheh");
					}
		return u;
	}

	@Override
	public List<User> getAllUser() {
		
		return repo.findAll();
	}

}
