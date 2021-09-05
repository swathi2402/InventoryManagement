package com.bridgelabz.stockaccountmanagement;

public class StockAccount {
	StockPortfolio stockPortfolio = new StockPortfolio();
	
	public void stockAccount() {
		stockPortfolio.addStocks();
	}
	
	public void valueOf() {
		stockPortfolio.calculateValues();
	}
}
