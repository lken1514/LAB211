package Controller;

import Controller.Sort;
import View.Menu;
import Model.Model;
import java.util.*;

public class ManageSort extends Menu {

    private Sort ms;
    private Model m;

    public ManageSort(Model model) {
        super("\nSort Options",
                new String[]{"Bubble Sort",
                        "Quick Sort",
                        "Exit"});
        ms = new Sort();
        //m = ms.getArr();
        m = model;
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            /*case 1:
                ms.inputArray();
                m = ms.getArr();
                break;*/
            case 1:
                if (m.getSize() == 0) {
                    System.out.println("Please input an array first (Option 1)");
                    break;
                }
                ms.display(m, "Unsorted array: ");
                ms.bubbleSort(m.getArray());
                ms.display(m, "Sorted array (Bubble Sort): ");
                break;
            case 2:
                if (m.getSize() == 0) {
                    System.out.println("Please input an array first (Option 1)");
                    break;
                }
                ms.display(m, "Unsorted array");
                ms.quickSort(m.getArray(), 0, m.getSize() - 1);
                ms.display(m, "Sorted array (Quick Sort)");
                break;
            case 3:
                System.out.println("Exiting the program.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

}


