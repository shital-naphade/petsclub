package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Category;
import com.example.demo.services.CategoryService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class CategoryController {

	@Autowired
	CategoryService cservice;
	
	@GetMapping("/allcategory")
	public List<Category> getAllCategory()
	{
		return cservice.getAllCategory();
	}
	
	
}
