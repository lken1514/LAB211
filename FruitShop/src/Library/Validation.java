/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

import Model.Fruit;
import java.util.ArrayList;

/**
 *
 * @author TRUNG KIEN
 */
public class Validation {
    Inputter inputter = new Inputter();

    public boolean isNumericDouble(String str) {
        try {
            Double.valueOf(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isNumericInt(String str) {
        try {
            Integer.valueOf(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public boolean checkInputYN() {
    while (true) {
        String input = inputter.getStringfromInput("Do you want to add another fruit?(Y/N): ");
        if (input.equalsIgnoreCase("Y")) {
            return true;
        } else if (input.equalsIgnoreCase("N")) {
            return false;
        } else {
            System.err.println("Must input Y or N to select option");
        }
    }
}

    public boolean checkIdExist(ArrayList<Fruit> ls, String id) {
        for (Fruit i : ls) {
            if (id.equalsIgnoreCase(i.getId())
                    ) {
                return false;
            }
        }
        return true;
    }
}
