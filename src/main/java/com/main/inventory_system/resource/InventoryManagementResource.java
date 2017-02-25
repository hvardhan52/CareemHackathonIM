package com.main.inventory_system.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.main.inventory_system.models.Driver;
import com.main.inventory_system.models.Operator;
import com.main.inventory_system.services.IneventoryManagementServiceImpl;
import com.main.inventory_system.services.InventoryManagementService;
import com.main.inventory_systen.helpers.InventoryManagementHelper;

@Path("/inventory/management")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InventoryManagementResource {
	
public InventoryManagementService inventoryManagementService;
	
	public InventoryManagementHelper getInventoryManagermentHelper(){
		return new InventoryManagementHelper();
	}
	
	@POST
	@Path("/createOpertaorDetails")
	public Response createOpertaor(Operator operator) {
		
		return getInventoryManagermentHelper().createOperator(operator);
	
	}
	
	@POST
	@Path("/createDriverDetails")
	public Response createDriver(Driver driver){
		
		return getInventoryManagermentHelper().createDriver(driver);
	
	}

}
