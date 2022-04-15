package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.OrderProductDetails;
import com.example.demo.services.OrderProductDetailsService;

@RestController
public class OrderProductDetailsController {

	@Autowired
	OrderProductDetailsService opservice;
	
	@GetMapping("/allorderproducts")
	public List<OrderProductDetails> getAllOrderProductsDetails()
	{
		return opservice.getAllOrderProductsDetails();
	}
}
