package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ProductMaster;
import com.example.demo.repositories.ProductMasterRepository;

@Service
public class ProductMasterService {

	@Autowired
	ProductMasterRepository prepo;
	
	public List<ProductMaster> getAllProducts()
	{
		return prepo.findAll();
	}
	
	public ProductMaster saveProduct(ProductMaster p)
	{
		return prepo.save(p);
	}
	
	public void insertProduct(int catid,String productname,String productdesc,int qty,double price)
	{
		prepo.insertProduct(catid,productname,productdesc,qty,price);
	}
	
//	public void deleteProduct(int pid)
//	{
//		prepo.deleteProduct(pid);
//	}
//	
	
	public ProductMaster getProductMaster(int id)
	{
		Optional<ProductMaster> od= prepo.findById(id);
		ProductMaster d = null;
		try
		{
			d = od.get();
		}
		catch(Exception e)
		{
			d=null;
		}
		return d;
	}
	
	public void deleteProductById(ProductMaster pm)
	{
		prepo.delete(pm);
	}

	public void updateProduct(int pid,String productname,String productdesc,int qty,double price)
	{
		prepo.updateProduct(pid,productname,productdesc,qty,price);
	}
}
