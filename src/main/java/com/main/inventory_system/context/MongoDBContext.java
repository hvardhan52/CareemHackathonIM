package com.main.inventory_system.context;

import com.mongodb.MongoClient;

public class MongoDBContext {
	

	
	private static MongoDBContext INSTANCE = new MongoDBContext();
	private MongoClient mongoClient;
	
	private MongoDBContext() {
	}

	public static MongoDBContext getInstance() {
		return INSTANCE;
	}

	public void init(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}
	
	public MongoClient getMongoClient(){
		return this.mongoClient;
	}

	



}
