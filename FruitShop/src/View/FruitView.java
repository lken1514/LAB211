/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Library.Inputter;
import Library.Validation;
import Model.Fruit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author TRUNG KIEN
 */
public class FruitView {

    private Inputter inputter = new Inputter();
    private Validation validate = new Validation();
    private Scanner scanner = new Scanner(System.in);
    private HashMap<String, ArrayList<Fruit>> orderHistory = new HashMap<>();

    public Fruit inputFruit(ArrayList<Fruit> ls) {
        Fruit newFruit = null;
        while (true) {
            String id = inputter.getStringFromInput("id ");
            if (ls.stream().anyMatch(f -> f.getId().equals(id))) {
                System.err.println("Id already exists. Please re-enter.");
                continue;
            }
            String name = inputter.getStringFromInput("name");
            double price = inputter.getDoubleFromInput("price");
            int quantity = inputter.getIntFromInput("quantity");
            String origin = inputter.getStringFromInput("origin");

            ls.add(new Fruit(id, name, price, quantity, origin));

            // Ask the user if they want to create another fruit
            if (!validate.checkInputYN()) {
                break;
            }
        }
        return newFruit;
    }

    public void displayShoppingList(ArrayList<Fruit> ls) {
        System.out.println("List of Fruits:");
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ | ++ Quantity ++ |");
        for (Fruit fruit : ls) {
            System.out.printf("| %-11d | %-16s | %-12s | %-11.6f$ | %-14d |\n",
                    ls.indexOf(fruit) + 1, fruit.getName(), fruit.getOrigin(), fruit.getPrice(), fruit.getQuantity());
        }
    }

    public void shopping(ArrayList<Fruit> ls, Hashtable<String, ArrayList<Fruit>> orderHistory) {
        //displayShoppingList(ls);

        ArrayList<Fruit> shoppingCart = new ArrayList<>();
        int selectedItemIndex;

        do {
            selectedItemIndex = selectItem(ls);

            if (selectedItemIndex != -1) {
                Fruit selectedFruit = ls.get(selectedItemIndex - 1);
                System.out.println("You selected: " + selectedFruit.getName());

                int maxQuantity = selectedFruit.getQuantity();
                int quantity;

                do {
                    System.out.printf("Please input quantity (up to %d): ", maxQuantity);

                    try {
                        quantity = scanner.nextInt();
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid quantity.");
                        scanner.nextLine(); 
                        continue;
                    }

                    scanner.nextLine(); 

                    if (quantity <= 0 || quantity > maxQuantity) {
                        System.out.println("Invalid quantity. Please enter a valid quantity.");
                    } else {
                        
                        selectedFruit.setQuantity(maxQuantity - quantity);
                        break;
                    }
                } while (true);

                double amount = selectedFruit.getPrice() * quantity;

                System.out.println("Do you want to order now? (Y/N)");
                String orderConfirmation = scanner.nextLine();

                if (orderConfirmation.equalsIgnoreCase("Y")) {
                    shoppingCart.add(new Fruit(selectedFruit.getName(), selectedFruit.getPrice(), quantity, selectedFruit.getOrigin()));

                    System.out.println("Product | Quantity | Price | Amount");
                    System.out.printf("%-8s | %-8d | %-5f$ | %-5.2f$\n", selectedFruit.getName(), quantity, selectedFruit.getPrice(), amount);
                    System.out.println("Total: " + amount + "$");

                    System.out.print("Input your name: ");
                    String customerName = scanner.nextLine();

                    ArrayList<Fruit> orderList = orderHistory.getOrDefault(customerName, new ArrayList<>());
                    orderList.addAll(shoppingCart);
                    orderHistory.put(customerName, orderList);

                    System.out.println("Order placed successfully. Returning to the main menu.");
                    break;
                } else {
                    System.out.println("Order canceled. Returning to the main menu.");
                    break;
                }
            } else {
                System.out.println("Invalid item selection. Returning to the main menu.");
                break;
            }
        } while (true);
    }

    public int selectItem(ArrayList<Fruit> s) {
        while (true) {
            System.out.print("Select an item (Enter Item Number, or 0 to exit): ");
            int selectedItemIndex;
            try {
                selectedItemIndex = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid item number.");
                scanner.nextLine(); // Consume the invalid input
                return -1;
            }
            scanner.nextLine(); // Consume the newline character

            if (selectedItemIndex == 0) {
                System.out.println("Exiting item selection.");
                return -1;
            } else if (selectedItemIndex < 1 || selectedItemIndex > s.size()) {
                System.out.println("Invalid item selection.");
            } else {
                return selectedItemIndex;
            }
        }
    }

    public void displayOrderHistory(Hashtable<String, ArrayList<Fruit>> orderHistory) {
        System.out.println("Order History:");
        for (String customerName : orderHistory.keySet()) {
            System.out.println("Customer: " + customerName);
            System.out.println("Items Ordered:");
            ArrayList<Fruit> orderList = orderHistory.get(customerName);
            System.out.printf("| %-20s | %-10s | %-15s |\n", "Fruit Name", "Quantity", "Price");
            for (Fruit fruit : orderList) {
                System.out.printf("| %-20s | %-10d | %-15.3f$ |\n", fruit.getName(), fruit.getQuantity(), fruit.getPrice());
            }
            System.out.println();
        }
    }

}
