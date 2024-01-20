/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author TRUNG KIEN
 */
import Model.Model;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Validate {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int getBase(String msg) {
        System.out.println(msg);
        while (true) {
            try {
                int base = Integer.parseInt(br.readLine());
                if (base == 2 || base == 10 || base == 16) {
                    return base;
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public String getValue(String msg, int base) {
        while (true) {
            try {
                System.out.println(msg);
                String value = br.readLine();
                switch (base) {
                    case 2:
                        if (value.matches("[0-1]+")) {
                            return value;
                        }
                        break;
                    case 10:
                        if (value.matches("[0-9]+")) {
                            return value;
                        }
                        break;
                    case 16:
                        if (value.matches("[0-9a-fA-F]+")) {
                            return value;
                        }
                        break;

                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }
    public Model inputValidateString(String msg) {
    Scanner sc = new Scanner(System.in);
    System.out.println(msg);
    do {
        String s = sc.nextLine();
        if (!s.isEmpty()) {
            return new Model(s);
        }
        System.err.println("Empty string is not allowed!");
    } while (true);
}


}


