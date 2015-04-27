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

import com.google.gson.Gson;

import fr.istic.sir.Service.HomeService;
import fr.istic.sir.resources.Home;

@Path("/homes")
public class HomeResource implements GenericResource<Home>{
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Home> getAll() {
		return new HomeService().findAll();
	}
	
	/**
	 * Get a home from this id encode in json
	 * @param int id
	 */
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Home get(@PathParam("id")int id) {
		return new HomeService().find(id);
	}

	/**
	 * Delete a home from this id encode in json
	 * @param id
	 */
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void delete(@PathParam("id")int id) {
		HomeService HomeS = new HomeService();
		HomeS.delete(HomeS.find(id));
	}

	/**
	 * Add a house
	 * @param jsonResult
	 * @return Response
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void add(String jsonResult) {
		//Here I can use Gson because the format of my prorieties are only int or String
		//So I use Gson for this rapidity and facility
		Gson gson = new Gson();
		Home home = gson.fromJson(jsonResult, Home.class);
		new HomeService().add(home);
	}
}
