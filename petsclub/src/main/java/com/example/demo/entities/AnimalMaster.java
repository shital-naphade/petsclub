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
@Table(name="animal_master")
public class AnimalMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int aid;
	
	@Column
	String breed;
	
	@Column
	String breeddesc;
	
	@Column
	int age;
	
	@Column
	int qty;
	
	@Column
	double price;
	
	@Column
	String certification;
	
	@JsonIgnoreProperties("animals")	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="catid")
	Category catid;

//	@JsonIgnoreProperties("aid")
//	@OneToMany(mappedBy = "aid",cascade=CascadeType.ALL)
//	Set<OrderAnimalDetails> orderanimals;
	
	

	public AnimalMaster() {
		super();
	}

	public AnimalMaster(int aid, String breed, String breeddesc, int age, int qty, double price, String certification,
			Category catid) {
		super();
		this.aid = aid;
		this.breed = breed;
		this.breeddesc = breeddesc;
		this.age = age;
		this.qty = qty;
		this.price = price;
		this.certification = certification;
		this.catid = catid;
	}

	public AnimalMaster(String breed, String breeddesc, int age, int qty, double price, String certification,
			Category catid) {
		super();
		this.breed = breed;
		this.breeddesc = breeddesc;
		this.age = age;
		this.qty = qty;
		this.price = price;
		this.certification = certification;
		this.catid = catid;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getBreeddesc() {
		return breeddesc;
	}

	public void setBreeddesc(String breeddesc) {
		this.breeddesc = breeddesc;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public Category getCatid() {
		return catid;
	}

	public void setCatid(Category catid) {
		this.catid = catid;
	}
//	
//	public Set<OrderAnimalDetails> getOrderanimals() {
//		return orderanimals;
//	}
//
//	public void setOrderanimals(Set<OrderAnimalDetails> orderanimals) {
//		this.orderanimals = orderanimals;
//		for(OrderAnimalDetails op : orderanimals)
//		{
//			op.setAid(this);	
//		}
//	}
	
	
}
