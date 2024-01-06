package Controller;

import Model.Model;
import java.util.*;



public class Sort {
    Scanner sc = new Scanner(System.in);
    Model m = new Model();
    

    public int[] bubbleSort(int[] array) {
        int size = array.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - (i + 1); j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
        
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    
    public int binarySearch(int[] array, int value, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (array[middle] == value) {
            return middle;
        } else if (array[middle] > value) {
            return binarySearch(array, value, left, middle - 1);
        } else {
            return binarySearch(array, value, middle + 1, right);
        }
    }

    public int linerSearch(Model m, int key) {
        int[] arr = m.getArray();
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public int getInput(String msg) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println(msg);
                while (!scanner.hasNextInt()) {
                    System.out.println("You must enter an integer!");
                    scanner.next();
                }
                int result = scanner.nextInt();
                if (result <= 0) {
                    System.out.println("You must enter a positive integer!");
                    continue;
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("You must enter a valid integer!");
            }
        }
    }


    public void display(Model m, String msg) {
        int[] array = m.getArray();
        int size = m.getSize();
        System.out.print(msg + "[ ");

        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");

            if (i != size - 1) {
                System.out.print(", ");
            }
        }

        System.out.println(" ]");
    }

    public void inputArray() {
        m.setSize(getInput("Enter number of elements:"));
        int[] array = new int[m.getSize()];

        for (int i = 0; i < m.getSize(); i++) {
            array[i] = getInput("Enter element " + (i + 1) + ":");
        }
        m.setArray(array);
    }
    
    public Model getArr(){
        return m;
    }
}
