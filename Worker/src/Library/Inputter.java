/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author TRUNG KIEN
 */
public class Inputter {
    private final Scanner sc = new Scanner(System.in);

    public double getDoubleFromInput(String name) {
        double number;
        while (true) {
            System.out.print(String.format(name));
            try {
                number = sc.nextDouble();
                if (number > 0) {
                    return number;
                } else {
                    System.err.println("Please enter the double number > 0 ");
                }
            } catch (InputMismatchException e) {
                System.err.println("Just input the double number > 0 ");
                sc.next();
            }
        }
    }

    public int getIntFromInput(String name) {
        int number;
        while (true) {
            System.out.print(String.format(name));
            try {
                number = Integer.parseInt(sc.nextLine());
                if (number > 0) {
                    return number;
                } else {
                    System.err.println("Please enter the integer number > 0 ");
                }
            } catch (InputMismatchException e) {
                System.err.println("Just input the integer number > 0 ");
                sc.next();
            }
        }
    }

    public String getString(String name) {
        String input;
        do {
            System.out.print(name);
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Input cannot be empty. Please try again.");
            }
        } while (input.isEmpty());
        return input;
    }

    public double getSalaryDouble(double a) {
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine().trim());
                if (result < a) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input salary > 0");
                System.out.print("Enter again: ");
            }
        }
    }
}

