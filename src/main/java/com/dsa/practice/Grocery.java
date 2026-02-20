package com.dsa.practice;
//Grocery class for invoice
class Grocery {
    String fruit;
    double price;  // unit price
    double total;  // total price after discount

    Grocery(String fruit, double price, double total) {
        this.fruit = fruit;
        this.price = price;
        this.total = total;
    }
}