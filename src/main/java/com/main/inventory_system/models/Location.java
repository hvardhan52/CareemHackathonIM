package com.main.inventory_system.models;

//
public class Location {
	
	 private  Double latitude;
	 private  Double longitude;

	 public Location (Double lat, Double lon) {
	        this.latitude = lat;
	        this.longitude = lon;
	    }
	    
	    
	 public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}


	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}


	public Location() {
		super();
	}


	public void setLocation(Double lat, Double lon){
	 this.latitude = lat;
     this.longitude = lon;
	 }
	 
	 public Double getlatitude(){
		 return this.latitude;
	 }
	 
	 public Double getlongitude(){
		 return this.longitude;
	 }

	    
}
