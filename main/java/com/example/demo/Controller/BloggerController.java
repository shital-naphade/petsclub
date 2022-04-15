package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Blogger;
import com.example.demo.services.BloggerService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class BloggerController {

	@Autowired
	BloggerService bservice;
	
	@GetMapping("/allblogs")
	public List<Blogger> getAllBlogger()
	{
		return bservice.getAllBlogger();
	}
	
	@PostMapping("/saveblog")
	public Blogger saveBlogger(@RequestBody Blogger b)
	{
		return bservice.saveBlogger(b);
	}
	
	@GetMapping("/deleteblog")
	public void delete(@RequestParam("bloggerid") int bloggerid)
	{
		bservice.deleteBlogger(bloggerid);
	}
}
