package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.AddToCart;
import com.example.demo.entities.ShoppingCart;
import com.example.demo.repositories.AddToCartRepository;

@Service
public class AddToCartService {

	@Autowired
	AddToCartRepository screpo;
	
	
	
	public void addAnimalToCart(AddToCart c)
	{
		screpo.insertAnimal(c.getSid(),c.getUserid(),c.getAid(),c.getQty(),c.getPrice());
		//screpo.save();
	}
	public void addProductToCart(AddToCart c)
	{
		screpo.insertProduct(c.getSid(),c.getUserid(),c.getPid(),c.getQty(),c.getPrice());
		//screpo.save();
	}
}
