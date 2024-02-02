/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.NormalCalModel;
import utils.Validate;


/**
 *
 * @author TRUNG KIEN
 */
public class NorView {
    Validate vl = new Validate();
    // Normal Calculate
    public void normalCalculator(NormalCalModel calModel) {
        System.out.println("-------- Normal Calculator -------");
        System.out.print("Enter number: ");
        calModel.setNum1(vl.checkInputDouble());
        calModel.setTempMem(calModel.getNum1());
        boolean flag = true;

        while (flag) {
            String operator = vl.getOperator("Enter Operator");
            switch (operator) {
                case "+":
                    calModel.setNum2(vl.checkInputDouble());
                    calModel.setTempMem(calModel.getTempMem() + calModel.getNum2());
                    System.out.println("Memory: " + calModel.getTempMem());
                    break;
                case "-":
                    calModel.setNum2(vl.checkInputDouble());
                    calModel.setTempMem(calModel.getTempMem() - calModel.getNum2());
                    System.out.println("Memory: " + calModel.getTempMem());
                    break;
                case "*":
                    calModel.setNum2(vl.checkInputDouble());
                    calModel.setTempMem(calModel.getTempMem() * calModel.getNum2());
                    System.out.println("Memory: " + calModel.getTempMem());
                    break;
                case "/":
                    calModel.setNum2(vl.checkInputDouble());
                    if (calModel.getNum2() != 0) {
                        calModel.setTempMem(calModel.getTempMem() / calModel.getNum2());
                        System.out.println("Memory: " + calModel.getTempMem());
                    } else {
                        System.err.println("Error: Division by zero");
                    }
                    break;
                case "^":
                    calModel.setNum2(vl.checkInputDouble());
                    calModel.setTempMem(Math.pow(calModel.getTempMem(), calModel.getNum2()));
                    System.out.println("Memory: " + calModel.getTempMem());
                    break;
                case "=":
                    System.out.println("Result: " + calModel.getTempMem());
                    flag = false;
                    break;
                case "exit":
                    System.out.println("Exiting Normal Calculator.");
                    flag = false;
                    break;
                default:
                    System.err.println("Invalid operator. Please input (+, -, *, /, ^, =, exit)");
                    break;
            }
        }
    }
}
