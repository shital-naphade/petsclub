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
@Table(name="order_product_details")
public class OrderProductDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int orderpid;
	
	@Column
	int quantity;
	
	@Column
	double price;
	
	@Column
	int orderid;
	
	@JsonIgnoreProperties("orderproducts")	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="pid")
	ProductMaster pid;

	public OrderProductDetails() {
		super();
	}

	public OrderProductDetails(int orderpid, int quantity, double price, int orderid, ProductMaster pid) {
		super();
		this.orderpid = orderpid;
		this.quantity = quantity;
		this.price = price;
		this.orderid = orderid;
		this.pid = pid;
	}

	public OrderProductDetails(int quantity, double price, int orderid, ProductMaster pid) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.orderid = orderid;
		this.pid = pid;
	}

	public int getOrderpid() {
		return orderpid;
	}

	public void setOrderpid(int orderpid) {
		this.orderpid = orderpid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public ProductMaster getPid() {
		return pid;
	}

	public void setPid(ProductMaster pid) {
		this.pid = pid;
	}
	
	
}
