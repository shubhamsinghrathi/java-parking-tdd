package com.indi.lot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.indi.lot.util.SlotManager;
import com.indi.lot.util.SlotNumberManager;

class TestSlotNumberManager {
	private SlotManager slotManager;
	
	@BeforeEach
	void setUp() {
		slotManager = new SlotNumberManager(4);
	}
	
	@Test
	void getSlotNumberTestOne() {
		assertEquals(0, slotManager.get());
	}
	
	@Test
	void getSlotNumberTestTwo() {
		slotManager.get();
		assertEquals(1, slotManager.get());
	}
	
	@Test
	void getSlotNumberTestThree() {
		slotManager.get();
		slotManager.get();
		slotManager.get();
		slotManager.add(1);
		assertEquals(1, slotManager.get());
	}

}
