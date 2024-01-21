/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controller;

/**
 *
 * @author TRUNG KIEN
 */
import View.Menu;
import View.StudentManage;

public class ProgramManagement extends Menu {

    public ProgramManagement() {
        super("WELCOME TO STUDENT MANAGEMENT", new String[]{"Create", "Find and Sort", "Update/Delete", "Report", "Exit"});
    }

    StudentManage st = new StudentManage();

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                st.loadData();
                st.displayAll();
                st.createStudent(choice, st);
                break;
            case 2:
                st.findAndSort(st);
                break;
            case 3:
                st.updateOrDelete();
                break;
            case 4:
                st.report(st);
                break;
            case 5:
                System.out.println("Program closing.");
                break;
            default:
                System.out.println("Option is not valid. Please make another selection!");
                System.out.println();   // tao khoang trong
                break;
        }
    }

}

