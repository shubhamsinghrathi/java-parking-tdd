package com.indi.lot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestManager {
	private Manager lotManager;
	
	@BeforeEach
	public void setUp() {
		lotManager = new LotManager();
	}

	@Test
	void lotCreationTestOne() {
		assertEquals("Created a parking lot with 6 slots", new LotManager().performAction("create_parking_lot 6"));
		assertEquals("Created a parking lot with 8 slots", new LotManager().performAction("create_parking_lot 8"));
	}
	
	@Test
	void lotCreationTestTwo() {
		lotManager.performAction("create_parking_lot 10");
		assertEquals("Invalid action", lotManager.performAction("create_parking_lot 8"));
	}

	@Test
	void carAddWhenLotNotCreated() {
		assertEquals("No parking lot created", lotManager.performAction("park KA-01-HH-1234 White"));
	}
	
	@Test
	void carAddWhenLotIsCreatedOne() {
		lotManager.performAction("create_parking_lot 2");
		assertEquals("Allocated slot number: 1", lotManager.performAction("park KA-01-HH-1234 White"));
	}
	
	@Test
	void carAddWhenLotIsCreatedTwo() {
		lotManager.performAction("create_parking_lot 4");
		lotManager.performAction("park KA-01-HH-1234 White");
		lotManager.performAction("park KA-01-HH-9999 White");
		lotManager.performAction("park KA-01-BB-0001 Black");
		assertEquals("Allocated slot number: 4", lotManager.performAction("park KA-01-HH-7777 Red"));
	}
	
}
