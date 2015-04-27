package fr.istic.sir.rest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import fr.istic.sir.Service.PersonService;
import fr.istic.sir.resources.Home;
import fr.istic.sir.resources.Person;

@Path("/persons")
public class PersonResource implements GenericResource<Person>{
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getAll() {
		return new PersonService().findAll();
	}
	
	/**
	 * Get a person from this id encode in json
	 * @param int id
	 */
	@GET
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Person get(@PathParam("id") int id) {
		return new PersonService().find(id);
	}

	/**
	 * Delete a person from this id encode in json
	 * @param id
	 */
	@DELETE
	@Path("/{id}")
	public void delete(int id) {
		PersonService PersonS = new PersonService();
		PersonS.delete(PersonS.find(id));
	}

	/**
	 * Add a person and also can add a home and then bind them together
	 * @param jsonResult
	 * @return Response
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void add(String jsonResult) {
		//Use JSONObject to decode json because GENSON or GSON don't work
		//Here GSon don't work because I can send home detail in the same json and also because he don't like the date format
		JSONObject personJson = new JSONObject(jsonResult);
		Person p = new Person(personJson.getString("firstName"),personJson.getString("lastName"));
		p.setSex(personJson.getString("sex"));
		p.setEmail(personJson.getString("email"));
		p.setFacebook(personJson.getString("facebook"));
		Date date = new Date(new Timestamp(personJson.getLong("birthday")).getTime());
		p.setBirthday(date);
		if (personJson.getBoolean("homeCreate")) {
			Home h = new Home(personJson.getString("homeAdress"));
			h.setArea(personJson.getInt("homeArea"));
			h.setIpAdress(personJson.getString("homeIpAdress"));
			List<Home> homes = new ArrayList<Home>();
			homes.add(h);
			p.setHomes(homes);
			h.setOwner(p);
		}
		new PersonService().add(p);
	}
}


