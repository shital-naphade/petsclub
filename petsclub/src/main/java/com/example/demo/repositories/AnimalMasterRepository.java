package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.AnimalMaster;

@Transactional
@Repository
public interface AnimalMasterRepository extends JpaRepository<AnimalMaster, Integer> {

	@Modifying
	@Query(value="Insert into animal_master (catid,breed,breeddesc,age,qty,price,certification) values (?1,?2,?3,?4,?5,?6,?7)",nativeQuery = true)
	public void saveAnimal(int catid,String breed,String breeddesc,int age, int qty,double price,String certification);
	
	@Modifying
	@Query(value="delete from animal_master where aid = ?1", nativeQuery = true)
	public void deleteAnimalById(int aid);
	
	@Modifying
	@Query(value="update animal_master set breed = ?2,breeddesc = ?3 ,age = ?4,qty = ?5,price = ?6,certification = ?7 where aid = ?1", nativeQuery = true)
	public void updateAnimal(int aid,String breed,String breeddesc,int age,int qty,double price,String certification);
}
