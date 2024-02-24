/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

import Model.Worker;
import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author TRUNG KIEN
 */
public class Validation {

    Scanner sc = new Scanner(System.in);
    private final String pattern = "W \\d+";

    public int checkInputIntLimit(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public int inputValidateInt(String msg) {
        int inputInt;
        do {
            try {
                System.out.println(msg);
                inputInt = Integer.parseInt(sc.nextLine());
                return inputInt;
            } catch (Exception e) {
                System.err.println("Empty input is not allowed! \n"
                        + "Only integers input accepted!");
            }

        } while (true);
    }

    public boolean isValidId(String id) {
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(id);
        return matcher.matches();
    }

    public String inputValidateString(String msg) {
        do {
            System.out.println(msg);
            String s = sc.nextLine();
            if (!s.isEmpty()) {
                return s;
            }
            System.err.println("Empty string is not allowed!");
        } while (true);
    }

    public boolean checkWorkerExist(ArrayList<Worker> lw, String id,
            String name, int age, double salary, String workLocation) {
        for (Worker worker : lw) {
            if (id.equalsIgnoreCase(worker.getId())
                    && name.equalsIgnoreCase(worker.getName())
                    && age == worker.getAge()
                    && salary == worker.getSalary()) {
                return false;
            }
        }
        return true;
    }
    
    public double checkInputSalary() {
        //loop until user input correct
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine().trim());
                if (result < 0) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Salary must be greater than 0");
                System.out.print("Enter again: ");
            }
        }
    }

    public boolean isValidAge(int yearOfBirth) {
        int currentYear = Year.now().getValue();
        int age = currentYear - yearOfBirth;

        // Check if the resulting age is between 18 and 50 and the input is a valid year
        return age >= 18 && age <= 50 && yearOfBirth <= currentYear;
    }
}
