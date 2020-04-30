package com.indi.lot.util;

public class DoublyLinkedList {
	private int total = 0;
	private DLLNode startNode = null;
	private DLLNode endNode = null;

	public Integer totalItems() {
		return total;
	}

	public void add(DLLNode dllNode) {
		if (startNode != null) {
			DLLNode prevNode = endNode;
			endNode = dllNode;
			prevNode.setNextNode(endNode);
			endNode.setPriviousNode(prevNode);
		} else {
			startNode = dllNode;
			endNode = dllNode;
		}
		total++;
	}

	public DLLNode getNodes() {
		return startNode;
	}

	public void remove(DLLNode dllNodeOne) {
		if (dllNodeOne.next() == null && dllNodeOne.previous() == null) {
			startNode = endNode = null;
		} else if (dllNodeOne.next() == null) {
			endNode = dllNodeOne.previous();
			dllNodeOne.previous().setNextNode(null);
		} else if (dllNodeOne.previous() == null) {
			startNode = dllNodeOne.next();
			dllNodeOne.next().setPriviousNode(null);
		} else {
			DLLNode nextEle = dllNodeOne.next();
			DLLNode prevEle = dllNodeOne.previous();
			dllNodeOne.previous().setNextNode(nextEle);
			nextEle.setPriviousNode(prevEle);
		}
		total--;
	}

}
