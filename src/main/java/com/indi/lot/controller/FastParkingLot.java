package com.indi.lot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.indi.lot.controller.entity.Car;
import com.indi.lot.util.ColorMapManager;
import com.indi.lot.util.DLLNode;
import com.indi.lot.util.DllNodeImpl;
import com.indi.lot.util.SlotManager;
import com.indi.lot.util.SlotNumberManager;

public class FastParkingLot implements ParkingLot {
	private int size;
	private List<Car> slots;
	private SlotManager slotNumberManager;
	private ColorMapManager cmm;
	
	private int actualSlotNumber(int slotNumber, boolean toSend) {
		if (toSend == false) return slotNumber - 1;
		return slotNumber + 1;
	}

	public FastParkingLot(int size) {
		this.size = size;
		slots = new ArrayList<Car>();
		for (int i=0; i<size; i++) {
			slots.add(null);
		}
		slotNumberManager = new SlotNumberManager(size);
		cmm = new ColorMapManager();
	}

	@Override
	public int addCar(String registrationNumber, String colour) {
		try {
			int slotNumber = slotNumberManager.get();
			Car car = new Car(registrationNumber, colour);
			slots.set(slotNumber, car);
			DLLNode node = new DllNodeImpl(slotNumber, car);
			cmm.add(node);
			car.setDllNode(node);
			return actualSlotNumber(slotNumber, true);
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public boolean removeCar(int i) {
		try {
			i = actualSlotNumber(i, false);
			Car car = slots.get(i);
			if (car == null) return false;
			carRemoveManager(car, i);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private void carRemoveManager(Car car, int slot) {
		slotNumberManager.add(slot);
		slots.set(slot, null);
		DLLNode node = car.getDllNode();
		cmm.remove(node);
	}

	@Override
	public Map<Integer, Car> getCarList() {
		Map<Integer, Car> slotMap = new HashMap<Integer, Car>();
		for (int i=0; i<size; i++) {
			if (slots.get(i) != null) {
				slotMap.put(actualSlotNumber(i, true), slots.get(i));
			}
		}
		return slotMap;
	}

	@Override
	public List<String> getCarRegistrationNumbersWithSameColor(String colour) {
		List<String> regNumbers = new ArrayList<String>();
		DLLNode node = cmm.get(colour);
		while (node != null) {
			regNumbers.add(node.getCar().getRegistrationNumber());
			node = node.next();
		}
		return regNumbers;
	}

	@Override
	public List<Integer> getCarSlotNumbersWithSameColor(String colour) {
		List<Integer> slotNumbers = new ArrayList<Integer>();
		DLLNode node = cmm.get(colour);
		while (node != null) {
			slotNumbers.add(actualSlotNumber(node.getSlot(), true));
			node = node.next();
		}
		return slotNumbers;
	}

}
