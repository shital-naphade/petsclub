package com.example.demo.Controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.mail.javamail.JavaMailSender;


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
	
	@Autowired
	JavaMailSender sender;
	
	@PostMapping("/register")
	public User register(@RequestBody User user)
	{
		System.out.println(user.getEmail()+""+user.getPassword());
		SimpleMailMessage mailMsg=new SimpleMailMessage();
		mailMsg.setFrom("petsclub74@gmail.com");
		mailMsg.setTo(user.getEmail());
		mailMsg.setSubject("Registration Mail");
		mailMsg.setText("Congratulation Your Registration is Successful on PetsClub System\n"+"Your Password Is : "+user.getPassword()+" please don't Share With AnyOne\n Thanks For Registration");
		//mailMsg.setText("Your Password Is : "+u.getPassword()+"plz don't Share With AnyOne");
	    //mailMsg.setText("Thanks For Registration");
		sender.send(mailMsg);
		return uservice.register(user);
	}
		
}
