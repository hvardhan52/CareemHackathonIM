package com.main.inventory_system.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.main.inventory_system.models.Car;
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
	@Path("/createOpertaorData")
	public Response createOpertaor(Operator operator) {
		
		return getInventoryManagermentHelper().createOperator(operator);
	
	}
	
	@POST
	@Path("/createDriverData")
	public Response createDriver(Driver driver){
		
		return getInventoryManagermentHelper().createDriver(driver);
	
	}

	@POST
	@Path("/createCarData")
	public Response createCar(Car car){
		
		return getInventoryManagermentHelper().createCar(car);
	
	}
	@POST
	@Path("/updateCarData")
	public Response updateCar(Car car) throws IllegalArgumentException, IllegalAccessException{
		
		return getInventoryManagermentHelper().updateCarData(car);
	
	}

	@POST
	@Path("/updateOperatorData")
	public Response updateOperator(Operator operator) throws IllegalArgumentException, IllegalAccessException{
		
		return getInventoryManagermentHelper().updateOperatorData(operator);
	
	}
	

	@POST
	@Path("/updateDriverData")
	public Response updateDriver(Driver driver) throws IllegalArgumentException, IllegalAccessException{
		
		return getInventoryManagermentHelper().updateDriverData(driver);
	
	}
	
	@POST
	@Path("/deleteDriverData")
	public Response deleteDriver(Driver driver) throws IllegalArgumentException, IllegalAccessException{
		
		return getInventoryManagermentHelper().deleteDriver(driver);
	
	}
	
	@POST
	@Path("/deleteCarData")
	public Response deleteCar(Car car) throws IllegalArgumentException, IllegalAccessException{
		
		return getInventoryManagermentHelper().deleteCar(car);
	
	}

	@POST
	@Path("/deleteOperatorData")
	public Response deleteOperator(Operator operator) throws IllegalArgumentException, IllegalAccessException{
		
		return getInventoryManagermentHelper().deleteOperator(operator);
	
	}
	
	

}
