package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entities.OrderAnimalDetails;
import com.example.demo.repositories.OrderAnimalDetailsRepository;

@Service
public class OrderAnimalDetailsService {

	@Autowired
	OrderAnimalDetailsRepository oarepo;
	
	public List<OrderAnimalDetails> getAllOrderAnimalDetails()
	{
		return oarepo.findAll();
	}
	
	public void saveOrderedAnimal(OrderAnimalDetails oa)
	{
		oarepo.save(oa);
	}
}
