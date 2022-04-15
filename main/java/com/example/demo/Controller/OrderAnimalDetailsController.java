package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.OrderAnimalDetails;
import com.example.demo.entities.OrderProductDetails;
import com.example.demo.services.OrderAnimalDetailsService;

@RestController
public class OrderAnimalDetailsController {

	@Autowired
	OrderAnimalDetailsService oaservice;
	
	@GetMapping("/allorderedanimals")
	public List<OrderAnimalDetails> getAllOrderAnimalDetails()
	{
		return oaservice.getAllOrderAnimalDetails();
	}
	
	@PostMapping("/saveorderedanimals")
	public void saveOrderedAnimal(@RequestBody OrderAnimalDetails oa)
	{
		oaservice.saveOrderedAnimal(oa);
	}
}
