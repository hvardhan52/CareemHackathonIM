package com.main.inventory_system.context;

import com.main.careem.inventory_system.Config;

public class ConfigContext {
	private Config config;
    
	private static ConfigContext instance= new ConfigContext();
	
	public ConfigContext() {
	}
	
	 public static ConfigContext getInstance() {
	        return instance;
	    }

	    public void init(Config config) {
	        this.config = config;
	    }

	    public Config getConfig() {
	        return config;
	    }
	
	
}
