package com.indi.lot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.indi.lot.controller.entity.Car;
import com.indi.lot.util.ColorMapManager;
import com.indi.lot.util.DLLNode;
import com.indi.lot.util.DllNodeImpl;

class TestColorMapManager {
	private ColorMapManager colorMapManager;
	
	@BeforeEach
	void setUp() {
		colorMapManager = new ColorMapManager();
	}
	
	@Test
	void getColorNodeTestOne() {
		assertEquals(null, colorMapManager.get("Red"));
	}
	
	@Test
	void getColorNodeTestTwo() {
		DLLNode node = new DllNodeImpl(1, new Car("UP-20-DS-3433", "Red"));
		colorMapManager.add(node);
		assertEquals(node, colorMapManager.get("Red"));
	}
	
	@Test
	void getColorNodeTestThree() {
		DLLNode node1 = new DllNodeImpl(1, new Car("UP-20-DS-3433", "Red"));
		DLLNode node2 = new DllNodeImpl(1, new Car("UP-20-DS-3444", "Blue"));
		DLLNode node3 = new DllNodeImpl(1, new Car("UP-20-DS-3463", "Red"));
		DLLNode node4 = new DllNodeImpl(1, new Car("UP-20-DS-3443", "Red"));
		colorMapManager.add(node1);
		colorMapManager.add(node2);
		colorMapManager.add(node3);
		colorMapManager.add(node4);
		colorMapManager.remove(node1);
		colorMapManager.remove(node2);
		assertEquals(node3, colorMapManager.get("Red"));
		assertEquals(null, colorMapManager.get("Blue"));
	}

}
