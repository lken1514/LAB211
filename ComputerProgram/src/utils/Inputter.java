/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author TRUNG KIEN
 */
public class Inputter {

    private final Validate vl = new Validate();

    public double getDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return vl.checkInputDouble();
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a valid double.");
            }
        }
    }

    public String getOperatorInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String result = vl.getOperator("");
            if (vl.isValidOperator(result)) {
                return result;
            }
            System.err.println("Please input (+, -, *, /, ^)");
        }
    }
}
