package com.unique.resources;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.plugins.providers.html.View;

import com.google.inject.Inject;
import com.unique.db.EmpDetail;
import com.unique.service.EmpService;

@Path("/emp")
public class EmpResources {

	@Inject
	EmpService es;

	@Inject
	private EntityManager em;

	@GET // simple Hello World
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public Response testMethod() {
		return Response.ok("Hello World").build();
	}

//	@GET				//get all value
//	@Path("/list")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response GetValue() {
//		  List<EmpDetail> list = es.getAllPersons();
//       return Response.ok(list).build();
//	}
	
	
	@GET		//return view page
	@Path("/list")
	public View GetValue() {
		List<EmpDetail> list = es.getAllPersons();
       return new View("/display.jsp",list,"EmpList");
	}			

	
	
//	@GET 					
//	@Path("/list/{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response GetEmpbyid(@PathParam("id") Integer id) {
//		EmpDetail ed = es.getEmpbyid(id);
//		return Response.ok(ed).build();
//	}
//	
	@GET 					
	@Path("/update/{id}")
	public View GetEmpbyid1(@PathParam("id") Integer id) {
		EmpDetail ed = es.getEmpbyid(id);
		return new View("/update.jsp",ed,"EmpById");
	}
	
	
//	@Path("/edit/{id}")
//	@PUT
//	public View updateUser1(@PathParam("id") int id, @FormParam("fname") String fname,
//			@FormParam("lname") String lname, @FormParam("city") String city) {
//		es.updateEmp(id, fname, lname, city);
//		return new View("/display.jsp","EmpList");
//	}
	

	
	
	@Path("/edit/{id}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser(@PathParam("id") int id, @FormParam("fname") String fname,
			@FormParam("lname") String lname, @FormParam("city") String city) {
			es.updateEmp(id, fname, lname, city);
		return Response.status(Response.Status.OK).build();
	}
	
	

	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(@FormParam("fname") String fname, @FormParam("lname") String lname,
			@FormParam("city") String city) {
		es.addEmp(fname, lname, city);
		return Response.status(200).entity("Added SuccessFullly!!!").build();
	}


	
	
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@DELETE
	public Response deleteUser(@PathParam("id") Integer id) {
		es.deleteEmp(id);
		return Response.status(200).entity("Deleted SuccessFullly!!!").build();
	}
	

	

	
	
	
}