package com.dsa.practice;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {

	public void manageInventory() {
		// 1. Define a LOCAL class inside the main method
		class InventoryItem {
			int productId;
			String name;
			int quantity;
			int restockLevel;

			// Constructor to initialize the fields
			public InventoryItem(int productId, String name, int quantity, int restockLevel) {
				this.productId = productId;
				this.name = name;
				this.quantity = quantity;
				this.restockLevel = restockLevel;
			}
		}

		// 2. Create a Map to store inventory items using productId as the key
		Map<Integer, InventoryItem> inventory = new HashMap<>();

		// 3. Add two items to the inventory
		// we use the constructor to initialize the fields of the local class, and
		// we insert the result into the map to manage multiple items.
		inventory.put(101, new InventoryItem(101, "Monitor", 5, 10));
		inventory.put(103, new InventoryItem(103, "Keyboard", 15, 10));

		// 4. Check if quantity < restockLevel and print the message
		for (InventoryItem item : inventory.values()) {
			if (item.quantity < item.restockLevel) {
				System.out.println("Alert! " + item.name + " needs restock");
			} else {
				System.out
						.println(item.name + " - Quantity: " + item.quantity + ", Restock Level: " + item.restockLevel);
			}
		}
	}

	public static void main(String[] args) {
		InventoryManager manager = new InventoryManager();
		// Call the method that contains the local class
		manager.manageInventory();
	}
}