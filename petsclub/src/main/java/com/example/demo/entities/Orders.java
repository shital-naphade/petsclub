package com.example.demo.entities;

import java.util.Date;

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
@Table(name="orders")
public class Orders {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int orderid;
	
	@Column
	Date orderdate;
	
	@Column
	double totalamount;
	
	@Column
	String paymentmode;
	
	@Column
	int transactionno;
	
	@JsonIgnoreProperties("orders")	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="userid")
	User userid;

	public Orders() {
		super();
	}

	public Orders(int orderid, Date orderdate, double totalamount, String paymentmode, int transactionno, User userid) {
		super();
		this.orderid = orderid;
		this.orderdate = orderdate;
		this.totalamount = totalamount;
		this.paymentmode = paymentmode;
		this.transactionno = transactionno;
		this.userid = userid;
	}

	public Orders(Date orderdate, double totalamount, String paymentmode, int transactionno, User userid) {
		super();
		this.orderdate = orderdate;
		this.totalamount = totalamount;
		this.paymentmode = paymentmode;
		this.transactionno = transactionno;
		this.userid = userid;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public double getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}

	public String getPaymentmode() {
		return paymentmode;
	}

	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}

	public int getTransactionno() {
		return transactionno;
	}

	public void setTransactionno(int transactionno) {
		this.transactionno = transactionno;
	}

	public User getUserid() {
		return userid;
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}
}
