package com.indi.lot.controller;

import java.util.List;
import java.util.Map;

import com.indi.lot.controller.entity.Car;

public interface ParkingLot {

	int addCar(String string, String string2);

	boolean removeCar(int i);

	Map<Integer, Car> getCarList();

	List<String> getCarRegistrationNumbersWithSameColor(String string);

	List<Integer> getCarSlotNumbersWithSameColor(String string);

}
