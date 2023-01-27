package com.unique.resources;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;
import com.unique.db.EmpDetail;
import com.unique.service.EmpService;

@Path("/emp")
public class EmpResources{
		
	@Inject
	EmpService es;
	
	@Inject
    private EntityManager em;
	
	@GET					//simple Hello World
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public Response testMethod() {
		return Response.ok("Hello World").build();
	}
	
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(@FormParam("fname") String fname,@FormParam("lname") String lname,@FormParam("city") String city) {
		es.addEmp(fname, lname, city);		
		return Response.status(200).entity("Added SuccessFullly!!!").build();
		
	}
	
	@Path("/delete/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUser(@PathParam("id") Integer id) {
		es.deleteEmp(id);
	return Response.status(200).entity("Deleted Successfully...").build();
	}
	
	
	@Path("/update/{id}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser(@PathParam("id") int id,@FormParam("fname") String fname,@FormParam("lname") String lname,@FormParam("city") String city) {
	es.updateEmp(id,fname, lname, city);	
	return Response.status(Response.Status.OK).build();
	}
	
	
	
	
	
	
	
	
}