package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.AddToCart;
import com.example.demo.entities.ShoppingCart;
import com.example.demo.services.AddToCartService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class AddToCartController {

	@Autowired
	AddToCartService scservice;
	
	@PostMapping("/addtocart1")
	public void addToCart(@RequestBody AddToCart c)
	{
		if(c.getAid() == 0)
		{
			System.out.println("Animal null");
			scservice.addProductToCart(c);//postman ==>{ "userid":"5"}
		}
		else if(c.getPid()== 0)
		{
			System.out.println("Product null");
			scservice.addAnimalToCart(c);//postman ==>{ "userid":"5"}
		}
		System.out.println("In Cart controller");
		System.out.println("Inserted successfully");
	}
}
