/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author TRUNG KIEN
 */
import java.util.Scanner;

public class Validate {

    private static final Scanner sc = new Scanner(System.in);

    public int validateInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Only integers are allowed!");
        }
    }

    public String validateString(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Empty string is not allowed!");
        }
        return input;
    }
}
