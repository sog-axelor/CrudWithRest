package com.unique.impl;

import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.query.Query;
import javax.ws.rs.NotFoundException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
			EmpDetail ed = new EmpDetail(fname,lname,city);
			emp.get().persist(ed);
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
	

	@Transactional
	@Override
	public List<EmpDetail> getAllPersons() {
		
		em = emp.get();
		List<EmpDetail> personList = em.createQuery("from EmpDetail", EmpDetail.class).getResultList();
		return personList;
	}

	@Override
	public EmpDetail getEmpbyid(int id) {
		em = emp.get();
		EmpDetail e = em.find(EmpDetail.class, id);
		return e;
	}



}
