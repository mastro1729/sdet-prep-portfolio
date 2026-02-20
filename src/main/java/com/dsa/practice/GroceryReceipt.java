package com.dsa.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroceryReceipt extends GroceryReceiptBase {

    public GroceryReceipt(Map<String, Double> prices, Map<String, Integer> discounts) {
        super(prices, discounts);
    }

    @Override
    public List<Grocery> Calculate(List<Node> shoppingList) {
        // Aggregate quantities for each fruit
        Map<String, Integer> aggregated = new HashMap<>();
        for (Node item : shoppingList) {
            aggregated.put(item.fruit, aggregated.getOrDefault(item.fruit, 0) + item.count);
        }

        List<Grocery> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : aggregated.entrySet()) {
            String fruit = entry.getKey();
            int quantity = entry.getValue();
            double unitPrice = getPrices().getOrDefault(fruit, 0.0);
            int discountPercent = getDiscounts().getOrDefault(fruit, 0);

            // Calculate total price after discount
            double totalPrice = quantity * unitPrice * (1 - discountPercent / 100.0);

            // Round to 1 decimal place
            totalPrice = Math.round(totalPrice * 10.0) / 10.0;

            result.add(new Grocery(fruit, unitPrice, totalPrice));
        }

        // Sort alphabetically
        result.sort(Comparator.comparing(g -> g.fruit));
        return result;
    }
}