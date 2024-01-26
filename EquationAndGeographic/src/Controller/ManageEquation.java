package Controller;

import View.Menu;

public class ManageEquation extends Menu {
   static Validate vl = new Validate();


    public ManageEquation(){
        super("======Equation Program======", new String[]{"-----Calculate Superlative Equation-----", "-----Calculate Quadratic Equation-----", "Exit"});


    }
    @Override
    public void execute(int choice) {
        switch (choice){
            case 1: superlativeEquation();
            break;
            case 2: quadraticEquation();
            break;
            case 3: System.exit(0);
        }

    }

    public static void superlativeEquation() {
        System.out.print("Enter A: ");
        double a = vl.checkInputDouble();
        System.out.print("Enter B: ");
        double b = vl.checkInputDouble();
        double x = -b / a;
        System.out.println("Solution: x=" + x);
        System.out.print("Number is odd: ");


        //mai sửa lại if cho gọn
        if (vl.checkOdd(a)) {
            System.out.print(a + " ");
        }
        if (vl.checkOdd(b)) {
            System.out.print(b + " ");
        }
        if (vl.checkOdd(x)) {
            System.out.print(x + " ");
        }
        System.out.print("Number is even: ");
        if (vl.checkEven(a)) {
            System.out.print(a + " ");
        }
        if (vl.checkEven(b)) {
            System.out.print(b + " ");
        }
        if (vl.checkEven(x)) {
            System.out.print(x + " ");
        }
        System.out.print("Number is perfect square: ");
        if (vl.checkSquareNumber(a)) {
            System.out.print(a + " ");
        }
        if (vl.checkSquareNumber(b)) {
            System.out.print(b + " ");
        }
        if (vl.checkSquareNumber(x)) {
            System.out.print(x + " ");
        }
    }

    //allow user calculate Quadratic Equation
    public static void quadraticEquation() {
        System.out.print("Enter A: ");
        double a = vl.checkInputDouble();
        System.out.print("Enter B: ");
        double b = vl.checkInputDouble();
        System.out.print("Enter C: ");
        double c = vl.checkInputDouble();
        double delta = b * b - 4 * a * c;
        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
        System.out.println("Solution: x1 = " + x1 + " and x2 = " + x2);
        System.out.print("Number is odd: ");


        //mai sửa lại if cho gọn
        if (vl.checkOdd(a)) {
            System.out.print(a + " ");
        }
        if (vl.checkOdd(b)) {
            System.out.print(b + " ");
        }
        if (vl.checkOdd(c)) {
            System.out.print(c + " ");
        }
        if (vl.checkOdd(x1)) {
            System.out.print(x1 + " ");
        }
        if (vl.checkOdd(x2)) {
            System.out.print(x2 + " ");
        }
        System.out.println();
        System.out.print("Number is even: ");
        if (vl.checkEven(a)) {
            System.out.print(a + " ");
        }
        if (vl.checkEven(b)) {
            System.out.print(b + " ");
        }
        if (vl.checkEven(c)) {
            System.out.print(b + " ");
        }
        if (vl.checkEven(x1)) {
            System.out.print(x1 + " ");
        }
        if (vl.checkEven(x2)) {
            System.out.print(x1 + " ");
        }
        System.out.println();
        System.out.print("Number is perfect square: ");
        if (vl.checkSquareNumber(a)) {
            System.out.print(a + " ");
        }
        if (vl.checkSquareNumber(b)) {
            System.out.print(b + " ");
        }
        if (vl.checkSquareNumber(c)) {
            System.out.print(c + " ");
        }
        if (vl.checkSquareNumber(x1)) {
            System.out.print(x1 + " ");
        }
        if (vl.checkSquareNumber(x2)) {
            System.out.print(x2 + " ");
        }
        System.out.println();
    }


}
