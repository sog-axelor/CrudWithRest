package com.unique.impl;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.unique.db.EmpDetail;
import com.unique.service.EmpService;

public class EmployeeImpl implements EmpService{
	

	@Inject
	Provider<EntityManager> emp;
	
	@Transactional
	@Override
	public void addEmp(String fname, String lname, String city) {
		
		EmpDetail ed = new EmpDetail();
		ed.setFname(fname);
		ed.setLname(lname);
		ed.setCity(city);
		emp.get().persist(ed);
		System.out.println("Your first name is : " + ed.getFname());
		System.out.println("Your Last name is : " + ed.getLname());
		System.out.println("Your City name is : " + ed.getCity());
		
	}
	

}
