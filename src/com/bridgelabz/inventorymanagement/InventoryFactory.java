package com.bridgelabz.inventorymanagement;

import java.util.Scanner;

import com.bridgelabz.linkedlist.MyLinkedList;
import com.bridgelabz.linkedlist.MyNode;

public class InventoryFactory {
	MyLinkedList<Inventory> myInventory = new MyLinkedList<Inventory>();

	public MyLinkedList<Inventory> getInventory() {
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
		return myInventory;
	}
}
