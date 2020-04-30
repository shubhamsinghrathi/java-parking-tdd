package com.indi.lot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.indi.lot.controller.entity.Car;
import com.indi.lot.util.DLLNode;
import com.indi.lot.util.DllNodeImpl;
import com.indi.lot.util.DoublyLinkedList;

class TestDoublyLinkedList {
	private DoublyLinkedList dll;
	
	@BeforeEach
	void setUp() {
		dll = new DoublyLinkedList();
	}

	@Test
	void getLengthTestOne() {
		assertEquals(0, dll.totalItems());
	}
	
	@Test
	void getLengthTestTwo() {
		DLLNode dllNode = new DllNodeImpl(1, new Car("DL-20-CC-3911", "Red"));
		dll.add(dllNode);
		assertEquals(1, dll.totalItems());
	}
	
	@Test
	void checkDLLTestOne() {
		DLLNode dllNodeOne = new DllNodeImpl(2, new Car("DL-20-CC-4911", "Blue"));
		DLLNode dllNodeTwo = new DllNodeImpl(5, new Car("DL-20-CC-3311", "Blue"));
		dll.add(dllNodeOne);
		dll.add(dllNodeTwo);
		
		DLLNode dllNodeStart = dll.getNodes();
		assertEquals(dllNodeOne, dllNodeStart);
		assertEquals(dllNodeTwo, dllNodeStart.next());
		assertEquals(null, dllNodeStart.previous());
		assertEquals(dllNodeOne, dllNodeTwo.previous());
		assertEquals(null, dllNodeTwo.next());
	}
	
	@Test
	void checkDLLTestTwo() {
		DLLNode dllNodeOne = new DllNodeImpl(2, new Car("DL-20-CC-4911", "Blue"));
		DLLNode dllNodeTwo = new DllNodeImpl(5, new Car("DL-20-CC-3311", "Blue"));
		DLLNode dllNodeThree = new DllNodeImpl(7, new Car("DL-20-CC-9911", "Blue"));
		dll.add(dllNodeOne);
		dll.add(dllNodeTwo);
		dll.add(dllNodeThree);
		dll.remove(dllNodeOne);
		
		DLLNode dllNodeStart = dll.getNodes();
		assertEquals(dllNodeTwo, dllNodeStart);
		assertEquals(dllNodeThree, dllNodeStart.next());
		assertEquals(null, dllNodeStart.previous());
		assertEquals(dllNodeTwo, dllNodeThree.previous());
		assertEquals(null, dllNodeThree.next());
	}
	
	@Test
	void checkDLLNodevalues() {
		DLLNode dllNodeOne = new DllNodeImpl(2, new Car("DL-20-CC-4911", "Blue"));
		assertEquals("Blue", dllNodeOne.getCar().getColour());
		assertEquals(2, dllNodeOne.getSlot());
	}

}
