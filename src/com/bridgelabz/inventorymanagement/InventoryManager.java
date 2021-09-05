package com.bridgelabz.inventorymanagement;

import com.bridgelabz.linkedlist.MyLinkedList;
import com.bridgelabz.linkedlist.MyNode;

public class InventoryManager {
	MyLinkedList<Inventory> myInventory;

	public void addInventory() {
		InventoryFactory inventoryFactory = new InventoryFactory();
		this.myInventory = inventoryFactory.getInventory();
	}

	public void calculateValue() {
		MyNode<Inventory> tempNode = (MyNode<Inventory>) myInventory.head;
		while (tempNode != null) {
			Inventory current = tempNode.getKey();
			double value = (current.getPrice() * current.getWeight());
			System.out.println("Value for inventory '" + current.getName() + "' is: " + value);
			tempNode = (MyNode<Inventory>) tempNode.getNext();
		}
	}
}
