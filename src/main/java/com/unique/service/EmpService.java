package com.unique.service;

import java.util.List;

import com.unique.db.EmpDetail;

public interface EmpService {
	void addEmp(String fname, String lname,String city);
	void updateEmp(int id,String fname, String lname,String city);
	void deleteEmp(int id);
	List<EmpDetail> getAllPersons();
	public EmpDetail getEmpbyid(int id);
}
