/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author TRUNG KIEN
 */
public class Inputter {

    private final Scanner sc;
    Validate vl = new Validate();

    public Inputter() {
        this.sc = new Scanner(System.in);
    }

    public int getIntInputWithRange(String prompt, int min, int max) {
        int result;
        do {
            System.out.print(prompt);
            try {
                result = Integer.parseInt(sc.nextLine().trim());
                if (vl.isValidIntRange(result, min, max)) {
                    return result;
                }
                System.err.println("Please input number in range [" + min + ", " + max + "]");
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a valid integer.");
            }
        } while (true);
    }

    public double getDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a valid double.");
            }
        }
    }

    public String getOperatorInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String result = sc.nextLine().trim();
            if (vl.isValidOperator(result)) {
                return result;
            }
            System.err.println("Please input (+, -, *, /, ^)");
        }
    }

    public String getStringInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String result = sc.nextLine().trim();
            if (vl.isValidString(result)) {
                return result;
            }
            System.err.println("Input cannot be empty. Please enter again.");
        }
    }

    public String getPhoneInput(String prompt) {
        // Loop until user input is correct
        while (true) {
            System.out.print(prompt);
            String result = getStringInput("");

            // Validate the phone number format
            if (vl.isValidPhone(result)) {
                return result;
            }

            // If the input is incorrect, display the message and ask for input again
            System.err.println("Invalid phone format. Please input according to the following format:\n"
                    + "• 1234567890\n"
                    + "• 123-456-7890 \n"
                    + "• 123-456-7890 x1234\n"
                    + "• 123-456-7890 ext1234\n"
                    + "• (123)-456-7890\n"
                    + "• 123.456.7890\n"
                    + "• 123 456 7890");
        }
    }
}
