package fr.istic.sir.resources;

import javax.persistence.Entity;

@Entity
public class Heater extends SmartDevice{

	private int temperatureMin;
	
	private int temperatureMax;
	
	private String power;
	
	public Heater(){}
	
	public Heater(String name, int tempMin, int tempMax) {
		super(name);
		this.temperatureMin = tempMin;
		this.temperatureMax = tempMax;
	}

	public int getTemperatureMin() {
		return temperatureMin;
	}

	public void setTemperatureMin(int temperatureMin) {
		this.temperatureMin = temperatureMin;
	}

	public int getTemperatureMax() {
		return temperatureMax;
	}

	public void setTemperatureMax(int temperatureMax) {
		this.temperatureMax = temperatureMax;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}
	
}
