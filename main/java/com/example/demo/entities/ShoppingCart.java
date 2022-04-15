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
	
	@Column
	double price;

	public ShoppingCart() {
		super();
		// TODO Auto-generated constructor stub
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
