package Controller;

import View.Menu;

public class ProgramManage extends Menu {

    ManageEquation me = new ManageEquation();
    ManageEastAsiaCountries mEAC = new ManageEastAsiaCountries();


    public ProgramManage(){
        super("=====Equation and East Asia Program=====", new String[]{"Equation Calculate", "East Asia program", "Exit"});
    }
    @Override
    public void execute(int choice) {
        switch (choice){
            case 1: me.run();
            case 2: mEAC.run();
            case 3: System.exit(0);
        }

    }
}
