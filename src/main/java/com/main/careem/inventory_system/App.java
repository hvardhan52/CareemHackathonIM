package com.main.careem.inventory_system;

import org.apache.solr.client.solrj.impl.HttpSolrClient;

import com.main.inventory_system.context.ConfigContext;
import com.main.inventory_system.context.MongoDBContext;
import com.main.inventory_system.context.SolrCarLocationContext;
import com.main.inventory_system.resource.InventoryManagementResource;
import com.main.inventory_system.resource.InventoryTrackingResource;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;


import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

/**
 * Hello world!
 *
 */
public class App extends Application<Config> {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		try {
			new App().run(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run(Config config, Environment environment) throws Exception {
		System.out.println("Hello Universe!");
		System.out.println("Hello config " + config.getTest());
		final MongoClient mongoClient = new MongoClient(new MongoClientURI(config.getMongoConnectionString()));
		final HttpSolrClient locationServer = new HttpSolrClient(config.getSolrConnectionString());
		SolrCarLocationContext.getInstance().init(locationServer);
		MongoDBContext.getInstance().init(mongoClient);
		ConfigContext.getInstance().init(config);
		environment.jersey().register(new InventoryManagementResource());
		environment.jersey().register(new InventoryTrackingResource());

	}
}
