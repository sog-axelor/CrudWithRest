package com.unique.service;

public interface EmpService {
	void addEmp(String fname, String lname,String city);
	void updateEmp(int id,String fname, String lname,String city);
	void deleteEmp(int id);
}
