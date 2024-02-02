/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.BMIModel;
import Model.NormalCalModel;
import View.BMIView;
import View.Menu;
import View.NorView;

/**
 *
 * @author TRUNG KIEN
 */
public class ProgramRun extends Menu{

    BMIView cm = new BMIView();
    NorView n = new NorView();
    NormalCalModel calModel = new NormalCalModel();

    public ProgramRun(){
        super("======= Computer Program =======", new String[]{"------- Normal Calculator-------", "------- Calculator BMI -------", "Exit"});

    }

    @Override
    public void execute(int choice) {
        switch (choice){
            case 1:
                n.normalCalculator(calModel);;
                break;
            case 2:
                cm.BMICalculator();
                break;
            case 3: System.exit(0);
        }
    }
}

