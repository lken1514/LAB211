/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author TRUNG KIEN
 */
public class Validate {

    Scanner sc = new Scanner(System.in);

    private final Pattern OPERATOR_PATTERN = Pattern.compile("[+\\-*/^=]");

    //allow user input number double
    public double checkInputDouble() {
    while (true) {
        try {
            String input = sc.nextLine().trim();
            
            if (input.isEmpty()) {
                throw new NumberFormatException("Input cannot be empty");
            }
            
            double result = Double.parseDouble(input);
            return result;
        } catch (NumberFormatException e) {
            System.err.println("Invalid input. Must be a double.");
        }
    }
}


    //allow user input operator
    public String getOperator(String msg) {
        while (true) {
            System.out.print(msg + ": ");
            String operator = sc.nextLine().trim();
            if (operator.isEmpty()) {
                System.err.println("Input cannot be empty");
            } else if (OPERATOR_PATTERN.matcher(operator).matches()) {
                return operator;
            } else {
                System.out.println("Please input (+, -, *, /, ^, =)");
            }
        }
    }

    //check input int
    public int checkInputInt() {
        int inputInt;
        do {
            try {
                inputInt = Integer.parseInt(sc.nextLine());
                return inputInt;
            } catch (Exception e) {
                System.err.println("Empty input is not allowed! \n"
                        + "Only integers input accepted!");
            }

        } while (true);
    }
    
    public boolean isValidOperator(String input) {
        return input.matches("[+\\-*/^=]");
    }
}
