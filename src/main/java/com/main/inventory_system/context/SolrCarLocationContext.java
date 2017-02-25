package com.main.inventory_system.context;

import org.apache.solr.client.solrj.impl.HttpSolrClient;

public class SolrCarLocationContext {
	
	private static SolrCarLocationContext instance = new SolrCarLocationContext();
	
	HttpSolrClient server;

	public static SolrCarLocationContext getInstance() {
		return instance;
	}

	public static void setInstance(SolrCarLocationContext instance) {
		SolrCarLocationContext.instance = instance;
	}
	
	public void init(HttpSolrClient server) {
		this.server = server;
	}
	
	public HttpSolrClient getSolrServer(){
		return this.server;
	}

}
