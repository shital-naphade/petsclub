package com.example.demo.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;

import com.example.demo.services.UserService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class UserController {

	@Autowired
	UserService uservice;
	
	@GetMapping("/allUsers")
	public List<User> getAll()
	{
		return uservice.getAll();
	}
	
	@PostMapping("/login")
	public User getUser(@RequestParam("email")String  email,@RequestParam("pwd")String pwd)
	{
		System.out.println(email+" "+pwd);
		User user=uservice.getUser(email, pwd);
		if(user!=null)
			return (User)user;
		else {
			User u =new User();
			return u;
		}
	}
	
	@PostMapping("/register")
	public User register(@RequestBody User user)
	{
		return uservice.register(user);
	}
		
}
