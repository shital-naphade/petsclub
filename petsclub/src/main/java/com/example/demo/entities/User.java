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
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int userid;
	
	@Column
	String fname;
	
	@Column
	String lname;
	
	@Column
	String email;
	
	@Column
	String password;
	
	@Column
	String contactno;
	
	@Column
	String address;
	
	@Column
	String gender;
	
	@Column
	String role;

//	@JsonIgnoreProperties("userid")					
//	@OneToMany(mappedBy = "userid", cascade= CascadeType.ALL)
//	Set<Orders> orders;
	
	public User() {
		super();
	}

	public User(int userid, String fname, String lname, String email, String password, String contactno, String address,
			String gender, String role) {
		super();
		this.userid = userid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.contactno = contactno;
		this.address = address;
		this.gender = gender;
		this.role = role;
	}

	public User(String fname, String lname, String email, String password, String contactno, String address,
			String gender, String role) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.contactno = contactno;
		this.address = address;
		this.gender = gender;
		this.role = role;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



	
}
