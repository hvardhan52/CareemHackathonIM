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

	public void updateOperatorData(Operator operator) throws IllegalArgumentException, IllegalAccessException {
		
		Document operatorDoc = UtilityMethods.JavaToDocument(operator);
		operatorCollection.updateOne(null, operatorDoc);
		
		
	}

	public void updateDriverData(Driver driver) {
		// TODO Auto-generated method stub
		
	}

	public void updateCarData(Car car) {
		// TODO Auto-generated method stub
		
	}

	public void deleteCar(String carId) {
		// TODO Auto-generated method stub
		
	}

	public void deleteOperator(String operatorId) {
		// TODO Auto-generated method stub
		
	}

	public void deleteDriver(String driverId) {
		// TODO Auto-generated method stub
		
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

	public void createCar(Car car) {
		// TODO Auto-generated method stub
		
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
