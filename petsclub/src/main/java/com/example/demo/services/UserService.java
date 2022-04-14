package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository urepo;
	
	public List<User> getAll()
	{
		return urepo.findAll();
	}
	
	public User getUser(String email,String pwd)
	{
		return urepo.getUser(email, pwd);
	}
	
	public User register(User user)
	{
		return urepo.save(user);
	}
	
}
