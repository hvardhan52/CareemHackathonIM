package com.main.inventory_system.services;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.google.gson.Gson;
import com.main.inventory_system.context.MongoDBContext;
import com.main.inventory_system.models.Car;
import com.main.inventory_system.models.Driver;
import com.main.inventory_system.models.Operator;
import com.main.inventory_system.services.InventoryManagementService;
import com.main.inventory_system.utilities.Constants;
import com.main.inventory_system.utilities.UtilityMethods;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

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
		
		Bson bson = new Document().append("operatorId" , operator.getOperatorId()); 
		Document operatorDoc = UtilityMethods.JavaToDocument(operator);
		operatorCollection.updateOne(bson, new Document("$set",operatorDoc));
		
	}

	public void updateDriverData(Driver driver) throws IllegalArgumentException, IllegalAccessException {
		Bson bson = new Document().append("driverId" , driver.getDriverId()); 
		Document driverDoc = UtilityMethods.JavaToDocument(driver);
		driverCollection.updateOne(bson, new Document("$set",driverDoc));
		
	}

	public void updateCarData(Car car) throws IllegalArgumentException, IllegalAccessException {
		Bson bson = new Document().append("carId" , car.getCarId()); 
		Document carDoc = UtilityMethods.JavaToDocument(car);
		carCollection.updateOne(bson, new Document("$set",carDoc));
		
	}

	public void deleteCar(Car car) {
		Bson bson = new Document().append("carId" , car.getCarId()); 
		carCollection.deleteOne(bson);
				
	}

	public void deleteOperator(Operator operator) {
		Bson bson = new Document().append("operatorId" , operator.getOperatorId()); 
		operatorCollection.deleteOne(bson);
				
	}

	public void deleteDriver(Driver driver) {
		Bson bson = new Document().append("driverId" , driver.getDriverId()); 
		driverCollection.deleteOne(bson);
				
		
	}

	public Driver findDriver(Long driverid) {
		try{
			Document filter = new Document("driverId",new Document("$eq",driverid));
			
			FindIterable<Document> drivers=driverCollection.find(filter);
			String driverString=JSON.serialize(drivers.first());
			
			return new Gson().fromJson(driverString, Driver.class);
		} catch (Exception e) {
			System.out.println(" Exception is  "+e.getMessage());
		}
		return null;
		
	}

	public Car findCar(String carId) {
		try{
			Long carIdLong = Long.parseLong(carId);
			Document filter = new Document("carId",new Document("$eq",carIdLong));
			
			FindIterable<Document> cars=carCollection.find(filter);
			String carString=JSON.serialize(cars.first());
			
			return new Gson().fromJson(carString, Car.class);
		} catch (Exception e) {
			System.out.println(" Exception is  "+e.getMessage());
		}
		return null;
		
	}

	public void findOperator(String operatorId) {
		// TODO Auto-generated method stub
		
	}

	public void createOperator(Operator operator) throws IllegalArgumentException, IllegalAccessException {
		
		Document operatorDoc = UtilityMethods.JavaToDocument(operator);
		operatorCollection.insertOne(operatorDoc);
		
	}

	public void createCar(Car car) throws IllegalArgumentException, IllegalAccessException {
		
		Document carDoc = UtilityMethods.JavaToDocument(car);
		carCollection.insertOne(carDoc);
		
		
	}

	public void createDriver(Driver driver) throws IllegalArgumentException, IllegalAccessException {
		
		Document driverDoc = UtilityMethods.JavaToDocument(driver);
		driverCollection.insertOne(driverDoc);
		
	}


}
