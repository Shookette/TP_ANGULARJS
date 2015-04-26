package fr.istic.sir.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import fr.istic.sir.dao.HomeService;
import fr.istic.sir.resources.Home;

@Path("/homes")
public class HomeResource {
	
	/**
	 * Get all homes from json
	 * @return List<Home> in JSON
	 */
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Home> gethomes() {
		return new HomeService().getAll();
	}
	
	/**
	 * Get a home from this id encode in json
	 * @param int id
	 */
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Home getHome(@PathParam("id") int id) {
		return new HomeService().getById(id);
	}
	
	/**
	 * Delete a home from this id encode in json
	 * @param id
	 */
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response deleteHome(@PathParam("id") int id) {
		new HomeService().delete(id);
		return Response.status(200).entity(true).build();
	}
	
	/**
	 * Add a house
	 * @param jsonResult
	 * @return Response
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addHome(String jsonResult) {
		//Here I can use Gson because the format of my prorieties are only int or String
		//So I use Gson for this rapidity and facility
		Gson gson = new Gson();
		Home home = gson.fromJson(jsonResult, Home.class);
		new HomeService().add(home);
		return Response.status(200).entity(true).build();
	}
}
