package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.AddToCart;
import com.example.demo.entities.AnimalMaster;
import com.example.demo.entities.ProductMaster;
import com.example.demo.entities.User;

@Transactional
@Repository
public interface AddToCartRepository extends JpaRepository<AddToCart, Integer> {

	@Modifying
	@Query(value="Insert into shopping_cart (sid,userid,pid,qty,price) values (?1,?2,?3,?4,?5)",nativeQuery = true)
	public void insertProduct(int sid,int user,int pid,int qty,double price);
	
	@Modifying
	@Query(value="Insert into shopping_cart (sid,userid,aid,qty,price) values (?1,?2,?3,?4,?5)",nativeQuery = true)
	public void insertAnimal(int sid,int user,int aid,int qty,double price);
}
