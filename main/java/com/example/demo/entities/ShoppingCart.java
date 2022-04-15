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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="shopping_cart")
public class ShoppingCart {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int sid;
	
	@JsonIgnoreProperties("products")	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="userid")
	User userid;
	
	@JsonIgnoreProperties("products")	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="pid")
	ProductMaster pid;
	
	@JsonIgnoreProperties("animals")	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="aid")
	AnimalMaster aid;
	
	@Column
	int qty;
	
	public ShoppingCart() {
		super();
	}

	public ShoppingCart(int sid, User userid, ProductMaster pid, AnimalMaster aid, int qty) {
		super();
		this.sid = sid;
		this.userid = userid;
		this.pid = pid;
		this.aid = aid;
		this.qty = qty;
	}

	public ShoppingCart(User userid, ProductMaster pid, AnimalMaster aid, int qty) {
		super();
		this.userid = userid;
		this.pid = pid;
		this.aid = aid;
		this.qty = qty;

	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public User getUserid() {
		return userid;
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}

	public ProductMaster getPid() {
		return pid;
	}

	public void setPid(ProductMaster pid) {
		this.pid = pid;
	}

	public AnimalMaster getAid() {
		return aid;
	}

	public void setAid(AnimalMaster aid) {
		this.aid = aid;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}


	
	
	/*
	Set<AnimalMaster> animalset;
	Set<ProductMaster> productset;
	public Set<AnimalMaster> getAnimalset() {
		return animalset;
	}
	public void setAnimalset(Set<AnimalMaster> animalset) {
		this.animalset = animalset;
	}
	public Set<ProductMaster> getProductset() {
		return productset;
	}
	public void setProductset(Set<ProductMaster> productset) {
		this.productset = productset;
	}*/
	
	
}