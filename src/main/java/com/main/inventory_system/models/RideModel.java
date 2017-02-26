package com.main.inventory_system.models;

import com.google.gson.Gson;

public class RideModel {
  
	private Driver driver;
	
	private Car car;

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		//return "RideModel [driver=" + driver + ", car=" + car + "]";
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
	
}
