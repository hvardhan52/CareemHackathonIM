package com.main.inventory_system.models;

import com.google.gson.Gson;

public class CarLocation {
	
	private String carId;
	
	private Location location;
	
	private Long timeStamp = System.currentTimeMillis();
    
    private Boolean status = false;

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
		//return "CarLocation [carId=" + carId + ", location=" + location + ", timeStamp=" + timeStamp + "]";
	}
    
    
}
