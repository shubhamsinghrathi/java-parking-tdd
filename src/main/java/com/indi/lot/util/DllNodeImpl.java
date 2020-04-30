package com.indi.lot.util;

import com.indi.lot.controller.entity.Car;

public class DllNodeImpl implements DLLNode {
	private DLLNode nextNode = null;
	private DLLNode priviousNode = null;
	private int slot;
	private Car car;

	public DllNodeImpl(int slot, Car car) {
		this.car = car;
		this.slot = slot;
	}

	@Override
	public DLLNode next() {
		return nextNode;
	}

	@Override
	public DLLNode previous() {
		return priviousNode;
	}

	public void setNextNode(DLLNode nextNode) {
		this.nextNode = nextNode;
	}

	public void setPriviousNode(DLLNode priviousNode) {
		this.priviousNode = priviousNode;
	}

	@Override
	public Car getCar() {
		return car;
	}

	@Override
	public Integer getSlot() {
		return slot;
	}

}
