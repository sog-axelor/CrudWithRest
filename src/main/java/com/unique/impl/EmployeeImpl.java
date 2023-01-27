package com.unique.impl;

import javax.persistence.EntityManager;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;
import com.unique.db.EmpDetail;
import com.unique.service.EmpService;

public class EmployeeImpl implements EmpService{
	
	@Inject
	private EntityManager em;
	
	@Inject
	private Provider<EntityManager> emp;
	
	@Transactional
	@Override
	public void addEmp(String fname, String lname, String city) {
			em.getTransaction().begin();
			EmpDetail ed = new EmpDetail(fname,lname,city);
			emp.get().persist(ed);
			em.getTransaction().commit();
				System.out.println("Your first name is : " + ed.getFname());
				System.out.println("Your Last name is : " + ed.getLname());
				System.out.println("Your City name is : " + ed.getCity());	
	}

	@Override
	public void deleteEmp(int id) {
		em.getTransaction().begin();
		EmpDetail ed = em.find(EmpDetail.class, id);
		em.remove(ed);
		em.getTransaction().commit();
		System.out.println("Your id is :" + id );
	}

	@Override
	public void updateEmp(int id,String fname, String lname, String city) {
		em.getTransaction().begin();
		em = emp.get();
		EmpDetail ed = em.find(EmpDetail.class, id);
		ed.setFname(fname);
		ed.setCity(city);
		ed.setLname(lname);
		em.getTransaction().commit();
		
	}
	
	

}
