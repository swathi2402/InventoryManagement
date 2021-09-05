package com.bridgelabz.inventorymanagement;

import java.util.Scanner;

import com.bridgelabz.linkedlist.MyLinkedList;


public class InventoryManagement {

	static MyLinkedList<Inventory> myInventory = new MyLinkedList<Inventory>();
	public static void main(String[] args) {
		System.out.println("*** Welcome to Inventory Data Management ***");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of Inventory");
		String name  = scanner.next();
		System.out.println("Enter weight in kg");
		double weight  = scanner.nextDouble();
		System.out.println("Enter the price per kg");
		double price = scanner.nextDouble();
		Inventory newInventory = new Inventory(name, weight, price);
		InventoryNode newNode = new InventoryNode(newInventory);
		System.out.println(newNode.getKey().getName());
		myInventory.add(newNode);
		
		CalculateValue calculateValue = new CalculateValue();
		calculateValue.calculateValue();
//		InventoryNode tempNode = (InventoryNode) myInventory.head;
//		System.out.println("h1" + tempNode);
//		while (tempNode != null) {
//			Inventory current = tempNode.getKey();
//			double value = (current.getPrice() * current.getWeight());
//			System.out.println("Value for inventory " + current.getName() + " is:" + value);
//			tempNode = (InventoryNode) tempNode.getNext();
//		}
		scanner.close();
	}

}
