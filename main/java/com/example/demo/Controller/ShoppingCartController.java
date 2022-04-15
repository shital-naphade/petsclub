package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.AnimalMaster;
import com.example.demo.entities.ShoppingCart;
import com.example.demo.services.ShoppingCartService;

@CrossOrigin(origins = "http://localhost:3000/")
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
	
	@PostMapping("/viewcart")
	public List<ShoppingCart> viewcart()
	{
		return scservice.viewcart();
	}
	
	@PostMapping("/addtocart")
	public void addToCart(@RequestBody ShoppingCart c)
	{
		if(c.getAid()==null)
		{
			System.out.println("Animal null");
			scservice.addProductToCart(c);//postman ==>{ "userid":"5"}
		}
		else if(c.getPid()==null)
		{
			System.out.println("Product null");
			scservice.addAnimalToCart(c);//postman ==>{ "userid":"5"}
		}
		System.out.println("In Cart controller");
		System.out.println("Inserted successfully");
	}
	
	@GetMapping("/deletefromcart")
	public void deleteFromCartById(@RequestParam("sid") int sid)
	{
		scservice.delete(sid); 
	}
}
