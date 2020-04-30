package com.indi.lot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.indi.lot.controller.FastParkingLot;
import com.indi.lot.controller.ParkingLot;
import com.indi.lot.controller.entity.Car;

class TestParkingLot {
	private ParkingLot parkingLot;
	
	@BeforeEach
	public void setUp() {
		parkingLot = new FastParkingLot(4);
	}
	
	@Test
	void addingCarToParkingLotOne() {
		assertEquals(1, parkingLot.addCar("UP-20-CC-2042", "White"));
	}
	
	@Test
	void addingCarToParkingLotTwo() {
		parkingLot.addCar("UP-20-CC-2042", "White");
		assertEquals(2, parkingLot.addCar("UP-20-CC-2044", "White"));
	}
	
	@Test
	void addingCarToParkingLotThree() {
		parkingLot.addCar("UP-20-CC-2040", "White");
		parkingLot.addCar("UP-20-CC-2041", "White");
		parkingLot.addCar("UP-20-CC-2042", "White");
		parkingLot.addCar("UP-20-CC-2043", "White");
		assertEquals(-1, parkingLot.addCar("UP-20-CC-2044", "White"));
	}
	
	@Test
	void removingCarFromParkingLotOne() {
		assertEquals(false, parkingLot.removeCar(1));
	}
	
	@Test
	void removeintCarFromParkingLotTwo() {
		parkingLot.addCar("UP-20-CC-2040", "White");
		assertEquals(true, parkingLot.removeCar(1));
	}
	
	@Test
	void addingCarToParkingLotFour() {
		parkingLot.addCar("UP-20-CC-2040", "White");
		parkingLot.addCar("UP-20-CC-2041", "White");
		parkingLot.addCar("UP-20-CC-2042", "White");
		parkingLot.addCar("UP-20-CC-2043", "White");
		parkingLot.removeCar(3);
		assertEquals(3, parkingLot.addCar("UP-20-CC-2044", "White"));
	}
	
	@Test
	void getCars() {
		parkingLot.addCar("UP-20-CC-2040", "Black");
		parkingLot.addCar("UP-20-CC-2041", "White");
		parkingLot.addCar("UP-20-CC-2042", "Blue");
		parkingLot.removeCar(2);
		Map<Integer, Car> slotMap = parkingLot.getCarList();
		slotMap.keySet().forEach(key -> {
			Car car = slotMap.get(key);
			if (key == 1) {
				assertEquals("UP-20-CC-2040 Black", car.getRegistrationNumber() + " " + car.getColour());
			} else {
				assertEquals("UP-20-CC-2042 Blue", car.getRegistrationNumber() + " " + car.getColour());
			}
		});
	}
	
	@Test
	void getCarRegistrationNumbersWithSameColor() {
		parkingLot.addCar("UP-20-CC-2040", "Black");
		parkingLot.addCar("UP-20-CC-2041", "Blue");
		parkingLot.addCar("UP-20-CC-2042", "Blue");
		List<String> registrationNumbers = parkingLot.getCarRegistrationNumbersWithSameColor("Blue");
		assertEquals(registrationNumbers.get(0), "UP-20-CC-2041");
		assertEquals(registrationNumbers.get(1), "UP-20-CC-2042");
	}
	
	@Test
	void getCarSlotNumbersWithSameColor() {
		parkingLot.addCar("UP-20-CC-2040", "Black");
		parkingLot.addCar("UP-20-CC-2041", "Blue");
		parkingLot.addCar("UP-20-CC-2042", "Blue");
		List<Integer> slotNumbers = parkingLot.getCarSlotNumbersWithSameColor("Blue");
		assertEquals(2, slotNumbers.get(0));
		assertEquals(3, slotNumbers.get(1));
	}

}
