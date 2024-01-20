/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author TRUNG KIEN
 */


import View.Menu;

public class ProgramManage extends Menu {
    //private final ManageChangeBaseNumber mc;
    private final ManageLetterCount ml;

    public ProgramManage(){
        super("-----Change Base System and Letter Count program-----", new String[]{"Letter Count","Exit program"});
        //mc = new ManageChangeBaseNumber();
        ml = new ManageLetterCount();


    }
    @Override
    public void execute(int choice) {
        switch (choice){
            case 1: ml.run();
            break;
            /*case 2: //mc.run();
            break;*/
            case 2:
                System.out.println("Exited.");
                break;
            default:
                System.err.println("Invalid choice. Please try again.");
                break;

        }

    }
}
