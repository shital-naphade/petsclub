package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.AnimalMaster;
import com.example.demo.entities.ProductMaster;
import com.example.demo.entities.ShoppingCart;
import com.example.demo.entities.User;

@Transactional
@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

	@Modifying
	@Query(value="Insert into shopping_cart (sid,userid,pid,qty) values (?1,?2,?3,?4)",nativeQuery = true)
	public void insertProduct(int sid,User user,ProductMaster pid,int qty);
	
	@Modifying
	@Query(value="Insert into shopping_cart (sid,userid,aid,qty) values (?1,?2,?3,?4)",nativeQuery = true)
	public void insertAnimal(int sid,User user,AnimalMaster aid,int qty);
	
	@Modifying
	@Query(value="delete from shopping_cart where sid = ?1",nativeQuery = true)
	public void deleteById(int sid);
}
