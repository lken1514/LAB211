package Controller;

import Model.Model;
import View.Menu;
import java.util.ArrayList;

public class Library extends Menu {
    private ArrayList<Model> array = new ArrayList<>();
    private ManageSort mso;
    private ManageSearch mse;
    //private Model[] arr;
    private Sort ms;
    private boolean arrayEntered = false;

    public Library() {
        super("Sort and Search System", new String[]{"Input Array","Sort", "Search", "Exit"});
        ms = new Sort();
        mso = new ManageSort(ms.getArr());
        mse = new ManageSearch(ms.getArr());
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                inputArray();
                break;
            case 2:
                if (!arrayEntered) {
                    System.out.println("Please input an array first.");
                    inputArray();
                }
                mso.run();
                break;
            case 3:
                if (!arrayEntered) {
                    System.out.println("Please input an array first.");
                    inputArray();
                }
                mse.run();
                break;
            case 4:
                System.out.println("Exited.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
                
        }
    }
    public void inputArray(){
        ms.inputArray();
        arrayEntered = true;
    }

    
}
