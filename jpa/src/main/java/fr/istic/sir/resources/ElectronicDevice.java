package fr.istic.sir.resources;

import javax.persistence.Entity;

@Entity
public class ElectronicDevice extends SmartDevice {

	private String type;

	public ElectronicDevice(){}
	
	public ElectronicDevice(String name,String type) {
		super(name);
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
