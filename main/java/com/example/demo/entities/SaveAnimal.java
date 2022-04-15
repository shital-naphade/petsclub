package com.example.demo.entities;

public class SaveAnimal {

	String breed;
	String breeddesc;
	int age;
	int qty;
	double price;
	String certification;
	int catid;
	public SaveAnimal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SaveAnimal(String breed, String breeddesc, int age, int qty, double price, String certification, int catid) {
		super();
		this.breed = breed;
		this.breeddesc = breeddesc;
		this.age = age;
		this.qty = qty;
		this.price = price;
		this.certification = certification;
		this.catid = catid;
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
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	
	
}
