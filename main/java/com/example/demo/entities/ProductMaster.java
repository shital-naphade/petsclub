package com.example.demo.entities;

import java.util.Set;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="product_master")
public class ProductMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int pid;
	
	@Column
	String productname;
	
	@Column
	String productdesc;
	
	@Column
	int qty;
	
	@Column
	double price;
	
	@JsonIgnoreProperties("products")	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="catid")
	Category catid;

	
//	@JsonIgnoreProperties("pid")
//	@OneToMany(mappedBy = "pid",cascade=CascadeType.ALL)
//	Set<OrderProductDetails> orderproducts;
	
	public ProductMaster() {
		super();
	}

	public ProductMaster(int pid, String productname, String productdesc, int qty, double price, Category catid) {
		super();
		this.pid = pid;
		this.productname = productname;
		this.productdesc = productdesc;
		this.qty = qty;
		this.price = price;
		this.catid = catid;
	}

	public ProductMaster(String productname, String productdesc, int qty, double price, Category catid) {
		super();
		this.productname = productname;
		this.productdesc = productdesc;
		this.qty = qty;
		this.price = price;
		this.catid = catid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductdesc() {
		return productdesc;
	}

	public void setProductdesc(String productdesc) {
		this.productdesc = productdesc;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCatid() {
		return catid;
	}

	public void setCatid(Category catid) {
		this.catid = catid;
	}
	
//	public Set<OrderProductDetails> getOrderproducts() {
//		return orderproducts;
//	}
//
//	public void setOrderproducts(Set<OrderProductDetails> orderproducts) {
//		this.orderproducts = orderproducts;
//		for(OrderProductDetails op : orderproducts)
//		{
//			op.setPid(this);	
//		}
//	}
}
