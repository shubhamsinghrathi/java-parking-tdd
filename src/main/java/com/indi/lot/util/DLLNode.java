package com.indi.lot.util;

import com.indi.lot.controller.entity.Car;

public interface DLLNode {

	DLLNode next();

	DLLNode previous();
	
	void setNextNode(DLLNode nextNode);
	
	void setPriviousNode(DLLNode priviousNode);

	Car getCar();

	Integer getSlot();

}
