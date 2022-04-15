package com.example.demo.entities;

public class SaveProduct
{
	
	String productname;
	String productdesc;
	int qty;
	double price;
	int catid;
	public SaveProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SaveProduct(String productname, String productdesc, int qty, double price, int catid) {
		super();
		this.productname = productname;
		this.productdesc = productdesc;
		this.qty = qty;
		this.price = price;
		this.catid = catid;
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
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	
}
