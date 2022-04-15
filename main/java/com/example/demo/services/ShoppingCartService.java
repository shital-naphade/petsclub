package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.AnimalMaster;
import com.example.demo.entities.ShoppingCart;
import com.example.demo.repositories.ShoppingCartRepository;

@Service
public class ShoppingCartService {

	@Autowired
	ShoppingCartRepository screpo;
	
	public List<ShoppingCart> viewcart()
	{
		return screpo.findAll();
		//screpo.save();
	}
	public void addAnimalToCart(ShoppingCart c)
	{
		screpo.insertAnimal(c.getSid(),c.getUserid(),c.getAid(),c.getQty());
		//screpo.save();
	}
	public void addProductToCart(ShoppingCart c)
	{
		screpo.insertProduct(c.getSid(),c.getUserid(),c.getPid(),c.getQty());
		//screpo.save();
	}
	
	public void delete(int sid)   
	{  
		screpo.deleteById(sid);  
	} 
}