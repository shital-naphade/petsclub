package com.example.demo.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Category;
import com.example.demo.entities.ProductMaster;
import com.example.demo.entities.SaveProduct;
import com.example.demo.services.ProductMasterService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class ProductMasterController {

	@Autowired
	ProductMasterService pservice;
	
	@GetMapping("/allproducts")
	public List<ProductMaster> getAllProducts()
	{
		return pservice.getAllProducts();
	}
	
//	@PostMapping("/saveproduct")
//	public ProductMaster saveProduct(@RequestBody ProductMaster p)
//	{
//		//Category catid=p.getCatid();
//		//System.out.println(catid.getCid());
//		return pservice.saveProduct(p);
//	}
	
	@PostMapping("/saveproduct")
	public void insertProduct(@RequestBody SaveProduct s)
	{
		System.out.println(s.getCatid());
		System.out.println(s.getProductname());
		System.out.println(s.getProductdesc());
		System.out.println(s.getQty());
		System.out.println(s.getPrice());
		pservice.insertProduct(s.getCatid(), s.getProductname(), s.getProductdesc(), s.getQty(), s.getPrice());
	}
	
//	@DeleteMapping("/deleteproduct/{pid}")
//	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable int pid) {
//		pservice.deleteProduct(pid);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
//	
//	@PostMapping("/deleteproduct")
//	public void deleteProductById(@RequestParam("pid")int pid)
//	{
//		pservice.deleteProductById(pid);
//	}
	
	@GetMapping("/deleteproduct/{id}")
	public void delete(@PathVariable int id)
	{
		ProductMaster pm=pservice.getProductMaster(id);
		pservice.deleteProductById(pm);
	}
	
	@PostMapping("/updateproduct")
	public void updateProduct(@RequestBody ProductMaster p)
	{
		System.out.println(p.getProductdesc());
		pservice.updateProduct(p.getPid(),p.getProductname(),p.getProductdesc(),p.getQty(),p.getPrice());
	}
	
}
