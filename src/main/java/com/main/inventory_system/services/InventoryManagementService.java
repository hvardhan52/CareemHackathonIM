package com.main.inventory_system.services;

import com.main.inventory_system.models.Car;
import com.main.inventory_system.models.Driver;
import com.main.inventory_system.models.Operator;

public interface InventoryManagementService {
	
	void createOperator(Operator operator) throws IllegalArgumentException, IllegalAccessException;
	
	void createCar(Car car);
	
	void createDriver(Driver driver);
	
	void updateOperatorData(Operator operator) throws IllegalArgumentException, IllegalAccessException;
	
	void updateDriverData(Driver driver);
	
	void updateCarData(Car car);
	
	void deleteCar(String carId);
	
	void deleteOperator(String operatorId);
	
	void deleteDriver(String driverId);
	
	void findDriver(String driverid);
	
	void findCar(String carId);
	
	void findOperator(String operatorId);

}
