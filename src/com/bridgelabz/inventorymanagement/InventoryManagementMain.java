package com.bridgelabz.inventorymanagement;

public class InventoryManagementMain {

	public static void main(String[] args) {
		System.out.println("*** Welcome to Inventory Data Management ***");
		InventoryManager inventoryManager = new InventoryManager();
		inventoryManager.addInventory();
		inventoryManager.calculateValue();
	}

}
