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

    Validate v = new Validate();
    Scanner sc = new Scanner(System.in);

    public String createCode(String msg, ManageDoctor manageDoctor) {
        do {
            System.out.println(msg);
            String code = v.validateString(sc.nextLine());
            if (!code.isEmpty() && !manageDoctor.isExistedCode(code)) {
                return code;
            }
            System.err.println("Code is null or duplicate in text file.");
        } while (true);
    }

    public String inputCode(String msg, ManageDoctor manageDoctor) {
        do {
            System.out.println(msg);
            String code = v.validateString(sc.nextLine());
            if (!code.isEmpty() && manageDoctor.isExistedCode(code)) {
                return code;
            }
            System.err.println("Code is null or not exist in text file.");
        } while (true);
    }

    public int inputInt(String msg) {
        do {
            try {
                System.out.println(msg);
                String input = new Scanner(System.in).nextLine();
                return v.validateInt(input);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        } while (true);
    }

    public String inputString(String msg) {
        do {
            try {
                System.out.println(msg);
                String input = new Scanner(System.in).nextLine();
                return v.validateString(input);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        } while (true);
    }
}
