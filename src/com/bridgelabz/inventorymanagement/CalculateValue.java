package com.bridgelabz.inventorymanagement;

import com.bridgelabz.linkedlist.MyLinkedList;

public class CalculateValue {
	MyLinkedList<Inventory> myInventory = new MyLinkedList<Inventory>();
	public void calculateValue() {
		InventoryNode tempNode = (InventoryNode) myInventory.head;
		System.out.println("h1" + tempNode);
		while (tempNode != null) {
			Inventory current = tempNode.getKey();
			double value = (current.getPrice() * current.getWeight());
			System.out.println("Value for inventory " + current.getName() + " is:" + value);
			tempNode = (InventoryNode) tempNode.getNext();
		}
	}
}
