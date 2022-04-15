package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Blogger;

import com.example.demo.repositories.BloggerRepository;

@Service
public class BloggerService {

	@Autowired
	BloggerRepository brepo;
	
	public List<Blogger> getAllBlogger()
	{
		return brepo.findAll();
	}
	
	public Blogger saveBlogger(Blogger b)
	{
		return brepo.save(b);
	}
	
	public void deleteBlogger(int bloggerid ) 
	{
		brepo.deleteById(bloggerid);
	}
}