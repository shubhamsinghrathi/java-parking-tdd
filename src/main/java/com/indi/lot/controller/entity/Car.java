package com.indi.lot.controller.entity;

import com.indi.lot.util.DLLNode;

public class Car {
	private String registrationNumber;
	private String colour;
	private DLLNode dllNode;

	public Car(String registrationNumber, String colour) {
		this.registrationNumber = registrationNumber;
		this.colour = colour;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public String getColour() {
		return colour;
	}
	
	public void setDllNode(DLLNode dllNode) {
		this.dllNode = dllNode;
	}

	public DLLNode getDllNode() {
		return dllNode;
	}

}
