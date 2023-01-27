package com.unique.listner;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;

import com.google.inject.Module;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.unique.module.EmpModule;

public class EmpListner extends GuiceResteasyBootstrapServletContextListener{
	
	@Override
	protected List<? extends Module> getModules(ServletContext context) {
		return Arrays.asList(new JpaPersistModule("myJpaUnit"),new EmpModule());

	}
}