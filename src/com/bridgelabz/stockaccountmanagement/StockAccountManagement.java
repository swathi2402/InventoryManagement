package com.bridgelabz.stockaccountmanagement;

public class StockAccountManagement {

	public static void main(String[] args) {
		System.out.println("*** Welcome to Stock Account Management ***");
		StockAccount stockAccount = new StockAccount();
		stockAccount.addStocks();
		stockAccount.calculateValues();
		stockAccount.buy(100, "abc");
		stockAccount.sell(100, "abc");
		stockAccount.printReport();
		stockAccount.stackDisplay();
		stockAccount.dateTimeDisplay();
	}

}
