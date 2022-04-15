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
@Table(name="shopping_cart")
public class AddToCart {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int sid;
	
	@Column
	int userid;
	
	@Column
	int pid;
	
	@Column
	int aid;
	
	@Column
	int qty;
	
	@Column
	double price;

	public AddToCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddToCart(int sid, int userid, int pid, int aid, int qty, double price) {
		super();
		this.sid = sid;
		this.userid = userid;
		this.pid = pid;
		this.aid = aid;
		this.qty = qty;
		this.price = price;
	}

	public AddToCart(int userid, int pid, int aid, int qty, double price) {
		super();
		this.userid = userid;
		this.pid = pid;
		this.aid = aid;
		this.qty = qty;
		this.price = price;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
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
	
	
	
}
