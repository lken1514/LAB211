package Controller;

import java.util.Scanner;

public class Validate {
    //check user input double
    public double checkInputDouble() {

        Scanner sc = new Scanner(System.in);
        //loop until user input correct
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input double");
                System.out.print("Enter again: ");
            }

        }
    }

    //check number is odd or not
    public boolean checkOdd(double n) {
        if (n % 2 == 1) {
            return true;
        } else {
            return false;
        }
    }

    //check number is even or not
    public boolean checkEven(double n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    //check number is square number or not
    public boolean checkSquareNumber(double n) {
        if((int) Math.sqrt(n) * (int) Math.sqrt(n) == n) {
            return true;
        } else {
            return false;
        }
    }
}
