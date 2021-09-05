package com.bridgelabz.stockaccountmanagement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.bridgelabz.hashtables.MyHashMap;
import com.bridgelabz.linkedlist.MyLinkedList;
import com.bridgelabz.linkedlist.MyNode;
import com.bridgelabz.stack.MyStack;

public class StockAccount {
	private MyLinkedList<Stock> stocksList = new MyLinkedList<Stock>();
	private MyStack<String> myPurchase = new MyStack<String>();
	private MyStack<String> mySelling = new MyStack<String>();
	private MyHashMap<String, LocalDateTime> dateTimeBuyQueue = new MyHashMap<String, LocalDateTime>();
	private MyHashMap<String, LocalDateTime> dateTimeSellQueue = new MyHashMap<String, LocalDateTime>();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
	
	public void addStocks() {
		System.out.println("Enter the number of Stocks that want to add: ");
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		for (int index = 0; index < count; index++) {
			System.out.println("Enter the name of stock");
			String name = scanner.next();
			System.out.println("Enter the number of shares");
			int numOfShares = scanner.nextInt();
			System.out.println("Enter the price for each share");
			double price = scanner.nextDouble();
			Stock stock = new Stock(name, numOfShares, price);
			MyNode<Stock> myStockNode = new MyNode<Stock>(stock);
			stocksList.append(myStockNode);
		}
		scanner.close();
	}

	public void calculateValues() {
		MyNode<Stock> tempNode = (MyNode<Stock>) stocksList.head;
		while (tempNode != null) {
			Stock stock = tempNode.getKey();
			tempNode.getKey().setValue(stock.getNumberOfShares() * stock.getSharePrice());
			tempNode = (MyNode<Stock>) tempNode.getNext();
		}
	}

	public void buy(int amount, String name) {
		MyNode<Stock> tempNode = (MyNode<Stock>) stocksList.head;
		System.out.println("Hi");
		while (tempNode != null && tempNode.getNext() != null) {
			if (tempNode.getKey().getName().equals(name)) {
				double sharePrice = tempNode.getKey().getSharePrice();
				int noOfShares = (int) (amount / sharePrice);
				int orginalNoOfShare = tempNode.getKey().getNumberOfShares();
				tempNode.getKey().setNumberOfShares(noOfShares + orginalNoOfShare);
				MyNode<String> nameInStack = new MyNode<String>(name);
				myPurchase.push(nameInStack);
				LocalDateTime now = LocalDateTime.now();
				dateTimeBuyQueue.add(name, now);
				System.out.println(noOfShares + " shares are added to " + name);
			}
			tempNode = (MyNode<Stock>) tempNode.getNext();
		}
		if (tempNode != null && tempNode.getNext() == null && tempNode.getKey().getName().equals(name)) {
			double sharePrice = tempNode.getKey().getSharePrice();
			int noOfShares = (int) (amount / sharePrice);
			int orginalNoOfShare = tempNode.getKey().getNumberOfShares();
			tempNode.getKey().setNumberOfShares(noOfShares + orginalNoOfShare);
			MyNode<String> nameInStack = new MyNode<String>(name);
			myPurchase.push(nameInStack);
			LocalDateTime now = LocalDateTime.now();
			dateTimeBuyQueue.add(name, now);
			System.out.println(noOfShares + " shares are added to " + name);
		}
	}

	public void sell(int amount, String name) {
		MyNode<Stock> tempNode = (MyNode<Stock>) stocksList.head;
		while (tempNode != null && tempNode.getNext() != null) {
			if (tempNode.getKey().getName().equals(name)) {
				double sharePrice = tempNode.getKey().getSharePrice();
				int noOfShares = (int) (amount / sharePrice);
				int orginalNoOfShare = tempNode.getKey().getNumberOfShares();
				int sell = orginalNoOfShare - noOfShares;
				if (sell > 0) {
					tempNode.getKey().setNumberOfShares(sell);
					MyNode<String> nameInStack = new MyNode<String>(name);
					mySelling.push(nameInStack);
					LocalDateTime now = LocalDateTime.now();
					dateTimeSellQueue.add(name, now);
					System.out.println(noOfShares + " shares are sold from " + name);
				} else {
					System.out.println("You have not enough shares");
				}
			}
			tempNode = (MyNode<Stock>) tempNode.getNext();
		}
		if (tempNode != null && tempNode.getNext() == null && tempNode.getKey().getName().equals(name)) {
			double sharePrice = tempNode.getKey().getSharePrice();
			int noOfShares = (int) (amount / sharePrice);
			int orginalNoOfShare = tempNode.getKey().getNumberOfShares();
			int sell = orginalNoOfShare - noOfShares;
			if (sell > 0) {
				tempNode.getKey().setNumberOfShares(sell);
				MyNode<String> nameInStack = new MyNode<String>(name);
				mySelling.push(nameInStack);
				LocalDateTime now = LocalDateTime.now();
				dateTimeSellQueue.add(name, now);
				System.out.println(noOfShares + " shares are sold from " + name);
			} else {
				System.out.println("You have not enough shares");
			}
		}
	}

	public void printReport() {
		MyNode<Stock> tempNode = (MyNode<Stock>) stocksList.head;
		System.out.println("------ Stock Report ------");
		while (tempNode != null) {
			System.out.println("Name: " + tempNode.getKey().getName());
			System.out.println("Number of shares: " + tempNode.getKey().getNumberOfShares());
			System.out.println("Share price: " + tempNode.getKey().getSharePrice());
			System.out.println("Total amount: " + tempNode.getKey().getValue());
			tempNode = (MyNode<Stock>) tempNode.getNext();
		}
	}
	
	public void stackDisplay() {
		System.out.println("Names of the stocks which were purchased");
		myPurchase.printStack();
		System.out.println("Names of the stocks which were sold");
		mySelling.printStack();
	}
	
	public void dateTimeDisplay() {
		System.out.println("Date and time of purchase");
		System.out.println(dateTimeBuyQueue);
		System.out.println("Date and time of sell");
		System.out.println(dateTimeSellQueue);
	}
}
