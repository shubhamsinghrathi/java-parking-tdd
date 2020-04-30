package com.indi.lot;

import java.util.List;
import java.util.Map;

import com.indi.lot.controller.FastParkingLot;
import com.indi.lot.controller.ParkingLot;
import com.indi.lot.controller.entity.Car;

public class LotManager implements Manager {
	private String invalidAction = "Invalid action";
	private ParkingLot parkingLot;
	
	private String[] stringSplitter(String str) {
		return str.split(" ");
	}

	@Override
	public String performAction(String actionStatement) {
		String[] actionStrings = stringSplitter(actionStatement);
		
		switch(actionStrings[0]) {
			case "create_parking_lot":
				if (parkingLot != null) return invalidAction;
				parkingLot = new FastParkingLot(Integer.valueOf(actionStrings[1]));
				return "Created a parking lot with " + actionStrings[1] + " slots";
			case "park":
				if (parkingLot == null) return "No parking lot created";
				else {
					int slotNumber = parkingLot.addCar(actionStrings[1], actionStrings[2]);
					if (slotNumber == -1) {
						return "Sorry, parking lot is full";
					} else {
						return "Allocated slot number: " + slotNumber;
					}
				}
			case "leave":
				if (parkingLot.removeCar(Integer.valueOf(actionStrings[1]))) {
					return "Slot number " + actionStrings[1] + " is free";
				} else {
					return "Car not found";
				}
			case "status":
				Map<Integer, Car> carMap = parkingLot.getCarList();
				System.out.println("Slot No.    Registration No    Colour");
				carMap.keySet().forEach(key -> {
					Car car = carMap.get(key);
					System.out.println(key + "           " + car.getRegistrationNumber() + "      " + car.getColour());
				});
				return null;
			case "registration_numbers_for_cars_with_colour":
				List<String> regNumbers = parkingLot.getCarRegistrationNumbersWithSameColor(actionStrings[1]);
				regNumbers.forEach(val -> {
					System.out.print(val + " ");
				});
				System.out.println("");
				return null;
			case "slot_numbers_for_cars_with_colour":
				List<Integer> slotNumbers = parkingLot.getCarSlotNumbersWithSameColor(actionStrings[1]);
				slotNumbers.forEach(val -> {
					System.out.print(val + " ");
				});
				System.out.println("");
				return null;
			default:
				return invalidAction;
		}
		
	}

}
