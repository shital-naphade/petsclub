package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.AnimalMaster;
import com.example.demo.entities.ShoppingCart;
import com.example.demo.repositories.ShoppingCartRepository;

@Service
public class ShoppingCartService {

	@Autowired
	ShoppingCartRepository screpo;
	
	public void addAnimalToCart(ShoppingCart c)
	{
		//screpo.save();
	}
}
