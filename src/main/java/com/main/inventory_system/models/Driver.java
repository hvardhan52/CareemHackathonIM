package com.main.inventory_system.models;

public class Driver {

	    private long driverId;

	    private String name;

	    private String dob;

	    private String governmentProofId;

	    private String address;

	    private String city;

	    private String country;

	    private String phoneNumber;

	    private String emailAddress;

	    private double rating;

	    public long getDriverId() {
	        return driverId;
	    }

	    public void setDriverId(long driverId) {
	        this.driverId = driverId;
	    }

	    public double getRating() {
	        return rating;
	    }

	    public void setRating(double rating) {
	        this.rating = rating;
	    }

	    public String getCountry() {
	        return country;
	    }

	    public void setCountry(String country) {
	        this.country = country;
	    }

	    public String getPhoneNumber() {
	        return phoneNumber;
	    }

	    public void setPhoneNumber(String phoneNumber) {
	        this.phoneNumber = phoneNumber;
	    }

	    public String getEmailAddress() {
	        return emailAddress;
	    }

	    public void setEmailAddress(String emailAddress) {
	        this.emailAddress = emailAddress;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getDob() {
	        return dob;
	    }

	    public void setDob(String dob) {
	        this.dob = dob;
	    }

	    public String getGovernmentProofId() {
	        return governmentProofId;
	    }

	    public void setGovernmentProofId(String governmentProofId) {
	        this.governmentProofId = governmentProofId;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    public String getCity() {
	        return city;
	    }

	    public void setCity(String city) {
	        this.city = city;
	    }
	    
}