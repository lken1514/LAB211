package Controller;

import Model.Equation;
import View.Menu;

public class ManageEquation extends Menu {
    static Validate vl = new Validate();
    Equation e = new Equation();


    public ManageEquation(){
        super("============Equation Program============", new String[]{"-----Calculate Superlative Equation-----",
                "-----Calculate Quadratic Equation-----", "Exit"});


    }
    @Override
    public void execute(int choice) {
        switch (choice){
            case 1: superlativeEquation(e);
                break;
            case 2: quadraticEquation(e);
                break;
            case 3: System.exit(0);
        }

    }

    public void superlativeEquation(Equation e) {
        System.out.print("Enter A: ");
        e.setA(vl.checkInputDouble());
        System.out.print("Enter B: ");
        e.setB(vl.checkInputDouble());
        double x = -e.getB() / e.getA();
        System.out.println("Solution: x=" + x);
        System.out.print("Number is odd: ");

        if (vl.checkOdd(e.getA())) {
            System.out.print(e.getA() + " ");
        }
        if (vl.checkOdd(e.getB())) {
            System.out.print(e.getB() + " ");
        }
        if (vl.checkOdd(x)) {
            System.out.print(x + " ");
        }
        System.out.print("\nNumber is even: ");
        if (vl.checkEven(e.getA())) {
            System.out.print(e.getA() + " ");
        }
        if (vl.checkEven(e.getB())) {
            System.out.print(e.getB() + " ");
        }
        if (vl.checkEven(x)) {
            System.out.print(x + " ");
        }
        System.out.print("\nNumber is perfect square: ");
        if (vl.checkSquareNumber(e.getA())) {
            System.out.print(e.getA() + " ");
        }
        if (vl.checkSquareNumber(e.getB())) {
            System.out.print(e.getB() + " ");
        }
        if (vl.checkSquareNumber(x)) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public void quadraticEquation(Equation e) {
        System.out.print("Enter A: ");
        e.setA(vl.checkInputDouble());
        System.out.print("Enter B: ");
        e.setB(vl.checkInputDouble());
        System.out.print("Enter C: ");
        e.setC(vl.checkInputDouble());
        double delta = e.getB() * e.getB() - 4 * e.getA() * e.getC();
        double x1 = (-e.getB() + Math.sqrt(delta)) / (2 * e.getA());
        double x2 = (-e.getB() - Math.sqrt(delta)) / (2 * e.getA());
        System.out.println("Solution: x1 = " + x1 + " and x2 = " + x2);
        System.out.print("Number is odd: ");

        if (vl.checkOdd(e.getA())) {
            System.out.print(e.getA() + " ");
        }
        if (vl.checkOdd(e.getB())) {
            System.out.print(e.getB() + " ");
        }
        if (vl.checkOdd(e.getC())) {
            System.out.print(e.getC() + " ");
        }
        if (vl.checkOdd(x1)) {
            System.out.print(x1 + " ");
        }
        if (vl.checkOdd(x2)) {
            System.out.print(x2 + " ");
        }
        System.out.println();
        System.out.print("\nNumber is even: ");
        if (vl.checkEven(e.getA())) {
            System.out.print(e.getA() + " ");
        }
        if (vl.checkEven(e.getB())) {
            System.out.print(e.getB() + " ");
        }
        if (vl.checkEven(e.getC())) {
            System.out.print(e.getC() + " ");
        }
        if (vl.checkEven(x1)) {
            System.out.print(x1 + " ");
        }
        if (vl.checkEven(x2)) {
            System.out.print(x2 + " ");
        }
        System.out.println();
        System.out.print("\nNumber is perfect square: ");
        if (vl.checkSquareNumber(e.getA())) {
            System.out.print(e.getA() + " ");
        }
        if (vl.checkSquareNumber(e.getB())) {
            System.out.print(e.getB() + " ");
        }
        if (vl.checkSquareNumber(e.getC())) {
            System.out.print(e.getC() + " ");
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

