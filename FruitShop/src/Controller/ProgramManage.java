/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author TRUNG KIEN
 */
import Model.Fruit;
import Model.Order;
import View.FruitView;
import View.Menu;
import View.OrderView;

import java.util.ArrayList;
import java.util.Hashtable;


public class ProgramManage extends Menu {

    public ProgramManage() {
        super("FRUIT SHOP SYSTEM", new String[]{"Create Fruit", "View Order", "Shopping(for buyer)", "Exit"});
    }
    
    ArrayList<Fruit> fruits = new ArrayList<>();
    OrderView order = new OrderView();
    FruitView fm = new FruitView();
    Hashtable<String, ArrayList<Fruit>> orderHistory = new Hashtable<>();
    

    @Override
    public void execute(int choice) {
    switch (choice) {
        case 1:
            fm.inputFruit(fruits);
            break;
        case 2:
            order.viewOrders(orderHistory);
            break;
        case 3:
            fm.displayShoppingList(fruits);
            //fm.selectItem(fruits);
            fm.shopping(fruits, orderHistory);
            break;
        case 4:
            System.out.println("Exit program.");
            break;
        default: 
            System.err.println("Invalid input. Please try again. ");
    }
}

    }

    

