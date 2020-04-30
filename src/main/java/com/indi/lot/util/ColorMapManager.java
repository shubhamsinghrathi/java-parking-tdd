package com.indi.lot.util;

import java.util.HashMap;
import java.util.Map;

public class ColorMapManager {
	private Map<String, DoublyLinkedList> colorMap = new HashMap<String, DoublyLinkedList>();

	public DLLNode get(String colour) {
		if (colorMap.containsKey(colour)) {
			return colorMap.get(colour).getNodes();
		} else {
			return null;
		}
	}

	public void add(DLLNode node) {
		String colour = node.getCar().getColour();
		DoublyLinkedList dll;
		if (colorMap.containsKey(colour)) {
			dll = colorMap.get(colour);
		} else {
			dll = new DoublyLinkedList();
			colorMap.put(colour, dll);
		}
		dll.add(node);
	}

	public void remove(DLLNode node) {
		String colour = node.getCar().getColour();
		if (colorMap.containsKey(colour)) {
			DoublyLinkedList dll = colorMap.get(colour);
			dll.remove(node);
			if (dll.totalItems() == 0) {
				colorMap.remove(colour);
			}
		}
	}

}
