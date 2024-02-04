/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.Menu;
import utils.ManageDoctor;

/**
 *
 * @author TRUNG KIEN
 */
public class DocManage extends Menu {

    ManageDoctor md = new ManageDoctor();

    public DocManage() {
        super("=======Welcome to Doctor Management System=======", new String[]{"Load file text and display in console", "Add Doctor", "Update Doctor",
            "Delete Doctor", "Search Doctor", "Exit program "});
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                md.readFile();
                md.display();
                break;
            case 2:
                md.addDoctor();
                break;
            case 3:
                md.updateDoctor();
                break;
            case 4:
                md.deleteDoctor();
                break;
            case 5:
                md.searchDoctor();
                break;
            case 6:
                System.exit(0);
        }

    }
}
