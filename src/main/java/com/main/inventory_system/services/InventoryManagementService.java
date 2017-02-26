package com.main.inventory_system.services;

import com.main.inventory_system.models.Car;
import com.main.inventory_system.models.Driver;
import com.main.inventory_system.models.Operator;

public interface InventoryManagementService {
	
	void createOperator(Operator operator) throws IllegalArgumentException, IllegalAccessException;
	
	void createCar(Car car) throws IllegalArgumentException, IllegalAccessException;
	
	void createDriver(Driver driver) throws IllegalArgumentException, IllegalAccessException;
	
	void updateOperatorData(Operator operator) throws IllegalArgumentException, IllegalAccessException;
	
	void updateDriverData(Driver driver) throws IllegalArgumentException, IllegalAccessException;
	
	void updateCarData(Car car) throws IllegalArgumentException, IllegalAccessException;
	
	void deleteCar(Car car);
	
	void deleteOperator(Operator operator);
	
	void deleteDriver(Driver driver);
	
	Driver findDriver(Long driverid);
	
	Car findCar(String carId);
	
	void findOperator(String operatorId);

}
