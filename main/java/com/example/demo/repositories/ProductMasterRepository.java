package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.ProductMaster;

@Transactional
@Repository
public interface ProductMasterRepository extends JpaRepository<ProductMaster, Integer> {

	@Modifying
	@Query(value="Insert into product_master (catid,productname,productdesc,qty,price) values (?1,?2,?3,?4,?5)",nativeQuery = true)
	public void insertProduct(int catid,String productname,String productdesc,int qty,double price);

	
//	@Modifying	
//	@Query("delete from product_master where pid = :pid")
//	public int deleteProduct(int pid);
	
	@Modifying
	@Query(value="delete from product_master where pid = ?1", nativeQuery = true)
	public void deleteProductById(int pid);
	
	@Modifying
	@Query(value="update product_master set productname = ?2 ,productdesc = ?3,qty = ?4 ,price = ?5 where pid = ?1", nativeQuery = true)
	public void updateProduct(int pid,String productname,String productdesc,int qty,double price);
	
}
