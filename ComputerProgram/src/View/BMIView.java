/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.BMIModel;
import Model.NormalCalModel;
import utils.Inputter;
import utils.Validate;

/**
 *
 * @author TRUNG KIEN
 */
public class BMIView {

    Validate vl = new Validate();
    BMIModel bmiModel = new BMIModel();

    // Display result BMI status
    public String BMIStatus(double bmi) {
        if (bmi < 19) {
            return "Under-standard.";
        } else if (bmi >= 19 && bmi < 25) {
            return "Standard.";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight.";
        } else if (bmi >= 30 && bmi < 40) {
            return "Fat-should lose weight";
        } else {
            return "Very fat - should lose weight immediately";
        }
    }

    // Allow user BMI calculator
    public void BMICalculator() {
        System.out.print("Enter Weight(kg): ");
        bmiModel.setWeight(vl.checkInputDouble());
        System.out.print("Enter Height(cm): ");
        bmiModel.setHeight(vl.checkInputDouble());
        double BMI = bmiModel.getWeight() * 10000 / (bmiModel.getHeight() * bmiModel.getHeight());
        System.out.printf("BMI number: %.2f\n", BMI);
        System.out.println("BMI Status: " + BMIStatus(BMI));
    }
}
