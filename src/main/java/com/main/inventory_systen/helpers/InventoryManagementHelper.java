package com.main.inventory_systen.helpers;

import javax.ws.rs.core.Response;

import org.bson.Document;

import com.main.inventory_system.context.MongoDBContext;
import com.main.inventory_system.models.Car;
import com.main.inventory_system.models.Driver;
import com.main.inventory_system.models.Operator;
import com.main.inventory_system.services.IneventoryManagementServiceImpl;
import com.main.inventory_system.utilities.Constants;
import com.main.inventory_system.utilities.UtilityMethods;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class InventoryManagementHelper {
	

	
	MongoDatabase db = MongoDBContext.getInstance().getMongoClient().getDatabase("InventoryManagementSystem");
	private MongoCollection<Document> operatorCollection;
	private MongoCollection<Document> driverCollection;
	private MongoCollection<Document> carCollection;
	
	public IneventoryManagementServiceImpl getIneventoryManagementServiceImpl() {
		return new IneventoryManagementServiceImpl();
	}

	public Response updateOperatorData(Operator operator) throws IllegalArgumentException, IllegalAccessException {
		
		try {
			getIneventoryManagementServiceImpl().updateOperatorData(operator);
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		return Response.status(Response.Status.OK).entity(Constants.SUCCESS_INSERT).build();	
		
		
	}

	public Response updateDriverData(Driver driver) throws IllegalArgumentException, IllegalAccessException {
		try {
			getIneventoryManagementServiceImpl().updateDriverData(driver);
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		return Response.status(Response.Status.OK).entity(Constants.SUCCESS_INSERT).build();	
		
		
	}

	public Response updateCarData(Car car) throws IllegalArgumentException, IllegalAccessException {
		try {
			getIneventoryManagementServiceImpl().updateCarData(car);;
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		return Response.status(Response.Status.OK).entity(Constants.SUCCESS_INSERT).build();
		
	}

	public Response deleteCar(Car car) {
		try {
			getIneventoryManagementServiceImpl().deleteCar(car);;
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		return Response.status(Response.Status.OK).entity(Constants.SUCCESS_INSERT).build();
		
	}

	public Response deleteOperator(Operator operator) {
		try {
			getIneventoryManagementServiceImpl().deleteOperator(operator);;
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		return Response.status(Response.Status.OK).entity(Constants.SUCCESS_INSERT).build();
		
	}

	public Response deleteDriver(Driver driver) {
		try {
			getIneventoryManagementServiceImpl().deleteDriver(driver);;
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		return Response.status(Response.Status.OK).entity(Constants.SUCCESS_INSERT).build();
		
	}

	public void findDriver(String driverid) {
		// TODO Auto-generated method stub
		
	}

	public void findCar(String carId) {
		// TODO Auto-generated method stub
		
	}

	public void findOperator(String operatorId) {
		// TODO Auto-generated method stub
		
	}

	public Response createOperator(Operator operator) {
		
		try {
			getIneventoryManagementServiceImpl().createOperator(operator);
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		return Response.status(Response.Status.OK).entity(Constants.SUCCESS_INSERT).build();
		
	}

	public Response createCar(Car car) {
		try {
			getIneventoryManagementServiceImpl().createCar(car);;
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		return Response.status(Response.Status.OK).entity(Constants.SUCCESS_INSERT).build();
		
	}

	public Response createDriver(Driver driver) {
		
		try {
			getIneventoryManagementServiceImpl().createDriver(driver);;
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		return Response.status(Response.Status.OK).entity(Constants.SUCCESS_INSERT).build();
		
	}



}
