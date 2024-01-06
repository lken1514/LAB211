package Controller;

import Model.Model;
import View.Menu;

public class ManageSearch extends Menu {

    private Sort ms;
    private Model m;

    public ManageSearch(Model model) {
        super("\nSearch Options",
                new String[]{"Linear Search",
                        "Binary Search",
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
                int searchKey = ms.getInput("Enter the value to search: ");
                int linearResult = ms.linerSearch(m,searchKey);
                if (linearResult != -1) {
                    System.out.println("Element found at index: " + linearResult);
                } else {
                    System.out.println("Element not found in the array.");
                }
                break;
            case 2:
                if (m.getSize() == 0) {
                    System.out.println("Please input an array first (Option 1)");
                    break;
                }
                ms.display(m, "Unsorted array");
                ms.quickSort(m.getArray(), 0, m.getSize() - 1);
                ms.display(m, "Sorted array");
                int searchValue = ms.getInput("Enter the value to search: ");
                int binaryResult = ms.binarySearch(m.getArray(), searchValue, 0, m.getSize() - 1);
                if (binaryResult != -1) {
                    System.out.println("Element found at index: " + binaryResult);
                } else {
                    System.out.println("Element not found in the array.");
                }
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
