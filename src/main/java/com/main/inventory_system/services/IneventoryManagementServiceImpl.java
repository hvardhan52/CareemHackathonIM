package com.main.inventory_system.services;

import org.bson.Document;

import com.main.inventory_system.context.MongoDBContext;
import com.main.inventory_system.models.Car;
import com.main.inventory_system.models.Driver;
import com.main.inventory_system.models.Operator;
import com.main.inventory_system.utilities.Constants;
import com.main.inventory_system.utilities.UtilityMethods;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class IneventoryManagementServiceImpl implements InventoryManagementService{
	
	MongoDatabase db = MongoDBContext.getInstance().getMongoClient().getDatabase("InventoryManagementSystem");
	private MongoCollection<Document> operatorCollection;
	private MongoCollection<Document> driverCollection;
	private MongoCollection<Document> carCollection;
	
	public IneventoryManagementServiceImpl() {
		this.operatorCollection = db.getCollection(Constants.OPERATOR_COLLECTION);
		this.driverCollection = db.getCollection(Constants.DRIVER_COLLECTION);
		this.carCollection = db.getCollection(Constants.CAR_COLLECTION);
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

	public void createOperator(Operator operator) throws IllegalArgumentException, IllegalAccessException {
		
		Document operatorDoc = UtilityMethods.JavaToDocument(operator);
		operatorCollection.insertOne(operatorDoc);
		
	}

	public void createCar(Car car) {
		// TODO Auto-generated method stub
		
	}

	public void createDriver(Driver driver) {
		// TODO Auto-generated method stub
		
	}

}
