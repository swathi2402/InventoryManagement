package com.bridgelabz.inventorymanagement;

import java.util.Scanner;

import com.bridgelabz.linkedlist.MyLinkedList;
import com.bridgelabz.linkedlist.MyNode;

public class DataManagement {
	MyLinkedList<Inventory> myInventory = new MyLinkedList<Inventory>();

	public void getInventory() {
		System.out.println("Enter total number of inventories: ");
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		
		for (int index = 0; index < count; index++) {
			System.out.println("Enter the name of Inventory");
			String name = scanner.next();
			System.out.println("Enter weight in kg");
			double weight = scanner.nextDouble();
			System.out.println("Enter the price per kg");
			double price = scanner.nextDouble();
			Inventory newInventory = new Inventory(name, weight, price);
			MyNode<Inventory> myStockNode = new MyNode<Inventory>(newInventory);
			myInventory.append(myStockNode);
		}
		scanner.close();
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
