package com.unique.module;

import com.google.inject.AbstractModule;
import com.unique.impl.EmployeeImpl;
import com.unique.resources.EmpResources;
import com.unique.service.EmpService;

public class EmpModule extends AbstractModule{
	
	@Override
	protected void configure() {
		bind(EmpResources.class);
		bind(EmpService.class).to(EmployeeImpl.class);
	}	
}