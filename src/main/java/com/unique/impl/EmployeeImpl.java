package com.unique.impl;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.unique.db.EmpDetail;
import com.unique.service.EmpService;

public class EmployeeImpl implements EmpService{
	
	@Inject
	private Provider<EntityManager> em;
	
	@Transactional
	@Override
	public void addEmp(String fname, String lname, String city) {
		EmpDetail ed = new EmpDetail(fname,lname,city);
		em.get().persist(ed);
		System.out.println("Your first name is : " + fname);
		System.out.println("Your Last name is : " + lname);
		System.out.println("Your City name is : " + city);
		
	}

}
