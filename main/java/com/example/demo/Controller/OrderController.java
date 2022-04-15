package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Orders;
import com.example.demo.services.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService oservice;
	
	@GetMapping("/allorders")
	public List<Orders> getAllOrders()
	{
		return oservice.getAllOrders();
	}
}
