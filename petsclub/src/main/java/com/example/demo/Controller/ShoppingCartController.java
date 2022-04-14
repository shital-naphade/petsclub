package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.AnimalMaster;
import com.example.demo.entities.ShoppingCart;
import com.example.demo.services.ShoppingCartService;

@RestController
public class ShoppingCartController {

	@Autowired
	ShoppingCartService scservice;
	
//	@PostMapping("/addanimaltocart")
//	public void addAnimalToCart(@RequestBody AnimalMaster am)
//	{
//		System.out.println("In Cart controller");
//		scservice.addAnimalToCart(am);
//	}
	
	@PostMapping("/addanimaltocart")
	public void addAnimalToCart(@RequestBody ShoppingCart c)
	{
		System.out.println("In Cart controller");
		scservice.addAnimalToCart(c);
	}
	
//	@PostMapping("/addanimaltocart")
//	public void addAnimalToCart(@RequestParam("userid")int userid,@RequestParam("aid")int aid,@RequestParam("qty")int qty,@RequestParam("price")double price)
//	{
//		System.out.println("In Cart controller");
//		scservice.addAnimalToCart(userid,aid,qty,price);
//	}
	
	@PostMapping("/addproducttocart")
	public void addProductToCart(@RequestBody AnimalMaster am)
	{
		
	}
}
