package com.bridgelabz.inventorymanagement;

import com.bridgelabz.linkedlist.INode;

public class InventoryNode implements INode<Inventory> {
	Inventory key;
	InventoryNode next;
	
	public InventoryNode(Inventory key) {
		super();
		this.key = key;
		this.next = null;
	}

	@Override
	public Inventory getKey() {
		return key;
	}
	@Override
	public INode<Inventory> getNext() {
		return next;
	}
	@Override
	public void setKey(Inventory key) {
		this.key = key;
	}
	@Override
	public void setNext(INode<Inventory> next) {
		this.next = (InventoryNode) next;
	}
}
