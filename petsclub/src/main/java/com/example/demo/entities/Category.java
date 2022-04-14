package com.example.demo.entities;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="category")
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int cid;
	
	@Column
	String catname;
	
//	@JsonIgnoreProperties("catid")					//To avoid infinite iterations---catid from ProdustMaster is ignored
//	@OneToMany(mappedBy = "catid", cascade= CascadeType.ALL)
//	Set<ProductMaster> products;
	
	/*
	@JsonIgnoreProperties("catid")					
	@OneToMany(mappedBy = "catid", cascade= CascadeType.ALL)
	Set<AnimalMaster> animals;*/

	public Category() {
		super();
	}
	/*
	public Category(int cid, String catname, Set<ProductMaster> products) {
		super();
		this.cid = cid;
		this.catname = catname;
		this.products = products;
	}

	public Category(String catname, Set<ProductMaster> products) {
		super();
		this.catname = catname;
		this.products = products;
	}

	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCatname() {
		return catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
	}

	public Set<ProductMaster> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductMaster> products) {
		this.products = products;
		for(ProductMaster p : products)
		{
			p.setCatid(this);	//Current instance of order has been set for foreign key 
		}
	}*/
	/*
	public Set<AnimalMaster> getAnimals() {
		return animals;
	}

	public void setAnimals(Set<AnimalMaster> animals) {
		this.animals = animals;
		for(AnimalMaster a : animals)
		{
			a.setCatid(this);	
		}
	}*/

	public Category(int cid, String catname) {
		super();
		this.cid = cid;
		this.catname = catname;
	}

	public Category(String catname) {
		super();
		this.catname = catname;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCatname() {
		return catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
	}
	
	
}
