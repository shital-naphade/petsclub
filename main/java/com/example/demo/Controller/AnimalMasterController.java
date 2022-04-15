package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.AnimalMaster;
import com.example.demo.entities.ProductMaster;
import com.example.demo.entities.SaveAnimal;
import com.example.demo.services.AnimalMasterService;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class AnimalMasterController {

	@Autowired
	AnimalMasterService aservice;
	
	@GetMapping("/allanimals")
	public List<AnimalMaster> getAllanimals()
	{
		return aservice.getAllAnimals();
	}
	
	@PostMapping("/saveanimal")
	public void saveAnimal(@RequestBody SaveAnimal a)
	{
		System.out.println(a.getCatid());
		System.out.println(a.getAge());
		System.out.println(a.getBreed());
		
		aservice.saveAnimal(a.getCatid(),a.getBreed(),a.getBreeddesc(),a.getAge(),a.getQty(),a.getPrice(),a.getCertification());
	}
	
//	@PostMapping("/saveanimal")
//	public void saveAnimal(@RequestBody AnimalMaster a)
//	{
//		aservice.saveAnimal(a);
//	}
	
//	@PostMapping("/deleteanimal")
//	public void deleteAnimalById(@RequestParam("aid")int aid)
//	{
//		aservice.deleteAnimalById(aid);
//	}
	
	@GetMapping("/deleteanimal/{id}")
	public void deleteAnimalById(@PathVariable int id)
	{
		AnimalMaster am=aservice.getAnimalMaster(id);
		aservice.deleteAnimalById(am);
	}
	
	@PostMapping("/updateanimal")
	public void updateAnimal(@RequestBody AnimalMaster a)
	{
		aservice.updateAnimal(a.getAid(),a.getBreed(),a.getBreeddesc(),a.getAge(),a.getQty(),a.getQty(),a.getCertification());
	}
}
