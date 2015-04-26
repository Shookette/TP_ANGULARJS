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

import org.json.JSONObject;

import fr.istic.sir.dao.HomeService;
import fr.istic.sir.dao.SmartDeviceService;
import fr.istic.sir.resources.ElectronicDevice;
import fr.istic.sir.resources.Heater;
import fr.istic.sir.resources.SmartDevice;

@Path("/devices")
public class SmartDeviceResource {
	
	/**
	 * Get all smartDevices from json
	 * @return List<SmartDevice> in JSON
	 */
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<SmartDevice> getSmartDevice() {
		return new SmartDeviceService().getAll();
	}

	/**
	 * Get a smartDevice from this id encode in json
	 * @param int id
	 */
	@GET
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SmartDevice getDevice(@PathParam("id") int id) {
		return new SmartDeviceService().getById(id);
	}
	
	/**
	 * Delete a smartDevice from this id encode in json
	 * @param id
	 */
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteDevice(@PathParam("id") int id) {
		new SmartDeviceService().delete(id);
	}
	
	/**
	 * Create a smartDevice and bind them with a house
	 * @param Json jsonResult
	 * @return Response
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addDevice(String jsonResult) {
		//Use JSONObject to decode json because GENSON or GSON don't work
		//Here GSon don't work because I can send data for a heater or a eletronicDevice both are SmartDevice
		JSONObject json = new JSONObject(jsonResult);
		if (json.getString("deviceType").equals("heater")) {
			Heater device = new Heater(json.getString("name"), json.getInt("temperatureMin"), json.getInt("temperatureMax"));
			device.setPower(json.getString("power"));
			device.setAvgCons(json.getInt("avgcons"));
			new SmartDeviceService().add(device);
			new HomeService().addDevice(json.getInt("homeid"), device);
		} else {
			ElectronicDevice device = new ElectronicDevice(json.getString("name"), json.getString("type"));
			device.setAvgCons(json.getInt("avgcons"));
			new SmartDeviceService().add(device);
			new HomeService().addDevice(json.getInt("homeid"), device);
		}
		return Response.status(200).entity(true).build();
	}
}