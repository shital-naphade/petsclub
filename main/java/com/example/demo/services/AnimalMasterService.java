package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.AnimalMaster;
import com.example.demo.entities.ProductMaster;
import com.example.demo.repositories.AnimalMasterRepository;

@Service
public class AnimalMasterService {

	@Autowired
	AnimalMasterRepository arepo;
	
	public List<AnimalMaster> getAllAnimals()
	{
		return arepo.findAll();
	}
	
	public void saveAnimal(int catid,String breed,String breeddesc,int age, int qty,double price,String certification)
	{
		arepo.saveAnimal(catid,breed,breeddesc,age,qty,price,certification);
	}
	
//	public void saveAnimal(AnimalMaster a)
//	{
//		arepo.save(a);
//	}
	
//	public void deleteAnimalById(int aid)
//	{
//		arepo.deleteAnimalById(aid);
//	}
	
	public AnimalMaster getAnimalMaster(int id)
	{
		Optional<AnimalMaster> od= arepo.findById(id);
		AnimalMaster obj = null;
		try
		{
			obj = od.get();
		}
		catch(Exception e)
		{
			obj=null;
		}
		return obj;
	}
	
	public void deleteAnimalById(AnimalMaster am)
	{
		arepo.delete(am);
	}
	
	public void updateAnimal(int aid,String breed,String breeddesc,int age,int qty,double price,String certification)
	{
		arepo.updateAnimal(aid,breed,breeddesc,age,qty,price,certification);
	}
}
