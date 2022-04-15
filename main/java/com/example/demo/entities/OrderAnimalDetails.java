package com.example.demo.entities;
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
@Table(name="order_animal_details")
public class OrderAnimalDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int orderaid;
	
	@Column
	int quantity;
	
	@Column
	double price;
	
	@Column
	int orderid;
	
	@JsonIgnoreProperties("orderanimals")	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="aid")
	AnimalMaster aid;
	
	/*@JsonIgnoreProperties("orderList")
	@ManyToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name="orderid")
	Order orderid;*/

	public OrderAnimalDetails() {
		super();
	}

	public OrderAnimalDetails(int orderaid, int quantity, double price, int orderid, AnimalMaster aid) {
		super();
		this.orderaid = orderaid;
		this.quantity = quantity;
		this.price = price;
		this.orderid = orderid;
		this.aid = aid;
	}

	public OrderAnimalDetails(int quantity, double price, int orderid, AnimalMaster aid) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.orderid = orderid;
		this.aid = aid;
	}

	public int getOrderaid() {
		return orderaid;
	}

	public void setOrderaid(int orderaid) {
		this.orderaid = orderaid;
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

	public AnimalMaster getAid() {
		return aid;
	}

	public void setAid(AnimalMaster aid) {
		this.aid = aid;
	}

	

}
