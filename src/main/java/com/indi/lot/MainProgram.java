package com.indi.lot;

public class MainProgram {

	public static void main(String[] args) {
		Manager m = new LotManager();
		String[] actionList = { "create_parking_lot 6", "park KA-01-HH-1234 White", "park KA-01-HH-9999 White",
				"park KA-01-BB-0001 Black", "park KA-01-HH-7777 Red", "park KA-01-HH-2701 Blue",
				"park KA-01-HH-3141 Black", "leave 4", "status", "park KA-01-P-333 White", "park DL-12-AA-9999 White",
				"registration_numbers_for_cars_with_colour White", "slot_numbers_for_cars_with_colour White" };
		
		int total = actionList.length;
		for (int i = 0; i < total; i++) {
			String action = actionList[i];
			String res = m.performAction(action);
			if (res != null) System.out.println(res);
		}
	}

}
