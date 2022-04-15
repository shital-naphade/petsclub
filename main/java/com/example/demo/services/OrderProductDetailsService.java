package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.OrderProductDetails;
import com.example.demo.repositories.OrderProductDetailsRepository;

@Service
public class OrderProductDetailsService {

	@Autowired
	OrderProductDetailsRepository oprepo;
	
	public List<OrderProductDetails> getAllOrderProductsDetails()
	{
		return oprepo.findAll();
	}
}
