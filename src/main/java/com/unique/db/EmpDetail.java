
package com.unique.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmpDetail{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private  String fname, lname,city;
	
	public EmpDetail() {
		super();
	}

	public EmpDetail(String fname, String lname, String city) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.city = city;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
}