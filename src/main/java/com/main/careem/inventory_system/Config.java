package com.main.careem.inventory_system;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Config extends Configuration {
 
	@JsonProperty("test") @NotEmpty
	private String test;
	
	@JsonProperty
	private String mongoConnectionString = "mongodb://localhost:27017/?maxPoolSize=900";
	
	@JsonProperty
	private String solrConnectionString = "http://localhost:8983/solr/carLocation";
	
	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String getMongoConnectionString() {
		return mongoConnectionString;
	}

	public void setMongoConnectionString(String mongoConnectionString) {
		this.mongoConnectionString = mongoConnectionString;
	}

	public String getSolrConnectionString() {
		return solrConnectionString;
	}

	public void setSolrConnectionString(String solrConnectionString) {
		this.solrConnectionString = solrConnectionString;
	}
	
	
}
