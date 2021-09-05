package com.bridgelabz.stockaccountmanagement;

public class StockAccountManagement {

	public static void main(String[] args) {
		System.out.println("*** Welcome to Stock Account Management ***");
		StockPortfolio stockPortfolio = new StockPortfolio();
		stockPortfolio.addStocks();
		double totalValue = stockPortfolio.calculateValues();
		System.out.println("Total value of all the stocks is: " + totalValue);
	}

}
