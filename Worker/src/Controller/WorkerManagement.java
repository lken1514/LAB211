/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.SalaryHistory;
import Model.Worker;
import View.Menu;
import View.WorkerView;
import java.util.ArrayList;


/**
 *
 * @author TRUNG KIEN
 */
public class WorkerManagement extends Menu {

    private WorkerView mg = new WorkerView();
    private ArrayList<Worker> lw = new ArrayList<>();
    private ArrayList<SalaryHistory> lh = new ArrayList<>();


    public WorkerManagement() {
        super("Worker Management", new String[]{"Add Worker", "Up salary", "Down salary", "Display Information salary", "Exit"});
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                mg.addWorker(lw);
                break;
            case 2:
                mg.upSalary(lw, lh);
                break;
            case 3:
                mg.downSalary(lw, lh);
                break;
            case 4:
                mg.printListHistory(lh);
                break;
            case 5: 
                System.out.println("Exit program. ");
                break;
            default: 
            System.err.println("Invalid input. Please try again. ");
        }
    }

}
