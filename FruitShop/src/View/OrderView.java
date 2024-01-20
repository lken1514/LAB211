/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Library.Validation;
import Model.Fruit;
import Model.Order;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author TRUNG KIEN
 */
public class OrderView {
    private List<Order> listOrder = new ArrayList<>();

    /*public void Ordering(Order newCustom) {     //add oder vào list
        listOrder.add(newCustom);
    }*/
    
    public void viewOrders(Hashtable<String, ArrayList<Fruit>> orderHistory) {
    if (orderHistory.isEmpty()) {
        System.err.println("No orders available.");
        return;
    }

    for (String customerName : orderHistory.keySet()) {
        System.out.println("Customer: " + customerName);

        ArrayList<Fruit> orderList = orderHistory.get(customerName);

        System.out.printf("%-10s | %-20s | %-15s | %-15s \n", "Product", "Quantity", "Price", "Amount");

        double totalAmount = 0.0;

        for (Fruit fruit : orderList) {
            double amount = fruit.getQuantity() * fruit.getPrice();
            totalAmount += amount;

            System.out.printf("%-10s | %-20s | %-15s | %-15s \n", fruit.getName(),
                    fruit.getQuantity(), fruit.getPrice(), String.format("%.2f", amount));
        }

        System.out.println(">> Total amount: $" + String.format("%.2f", totalAmount));
        System.out.println(); 
    }
}
    
}
