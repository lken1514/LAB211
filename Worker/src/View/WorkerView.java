/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Library.Inputter;
import Library.Validation;
import Model.SalaryHistory;
import Model.Worker;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.*;

/**
 *
 * @author TRUNG KIEN
 */
public class WorkerView {

    Inputter i = new Inputter();
    Validation v = new Validation();

    public void addWorker(ArrayList<Worker> lw) {
        Scanner sc = new Scanner(System.in);
        int userChoice;
        System.out.println("-------------Add Worker---------------");

        do{
            String id;
            do {
                id = i.getString("Enter ID: ");
                if (!v.isValidId(id)) {
                    System.err.println("Invalid ID format. Please try again.");
                }
            } while (!v.isValidId(id));

            String name = i.getString("Enter name: ");

            int birthYear = 0;
            do {
                birthYear = i.getIntFromInput("Enter year of birth: ");
                if (!v.isValidAge(birthYear)) {
                    System.err.println("Invalid birth year. Birth year must be <= current year and age be between 18 and 50.");
                }
            } while (!v.isValidAge(birthYear));

            int age = Year.now().getValue() - birthYear;

            System.out.print("Enter Salary: ");
            double salary = i.getSalaryDouble(0);
            String workLocation = i.getString("Enter work location: ");

            if (!v.checkWorkerExist(lw, id, name, age, salary, workLocation)) {
                System.err.println("Duplicate.");
            } else {
                lw.add(new Worker(id, name, age, salary, workLocation));
                System.err.println("Add success.");
            }

            System.out.println("Do you want to continue adding another worker?");
            System.out.println("Press 1 to continue! || Any other number to end function!");

            try {
                userChoice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                userChoice = 0;  
            }
        } while (userChoice == 1);
    }

    public void adjustSalary(ArrayList<Worker> lw, ArrayList<SalaryHistory> lh, String type) {
        String id = i.getString("Enter Id: ");
        Worker w = getWorkerByCode(lw, id);

        if (w != null) {
            System.out.println("Enter salary: ");
            double salary = v.checkInputSalary();

            if (salary > 0) {
                double currentSalary = w.getSalary();
                int totalSalary = 0;

                if ("UP".equalsIgnoreCase(type)) {
                    totalSalary = (int) (currentSalary + salary);
                    lh.add(new SalaryHistory("UP", getCurrentDate(), w.getId(), w.getName(), w.getAge(), salary, w.getWorkLocation()));
                } else if ("DOWN".equalsIgnoreCase(type)) {
                    if (currentSalary > salary) {
                        totalSalary = (int) (currentSalary - salary);
                        lh.add(new SalaryHistory("DOWN", getCurrentDate(), w.getId(), w.getName(), w.getAge(), salary, w.getWorkLocation()));
                    } else {
                        System.out.println("Must be greater than current salary");
                        return;
                    }
                }

                w.setSalary(totalSalary);
            } else {
                System.out.println("Must be greater than 0");
            }
        }
    }

    public void upSalary(ArrayList<Worker> lw, ArrayList<SalaryHistory> lh) {
        adjustSalary(lw, lh, "UP");
    }

    public void downSalary(ArrayList<Worker> lw, ArrayList<SalaryHistory> lh) {
        adjustSalary(lw, lh, "DOWN");
    }

    public Worker getWorkerByCode(ArrayList<Worker> lw, String id) {
        for (Worker worker : lw) {
            if (id.equalsIgnoreCase(worker.getId())) {
                return worker;
            }
        }
        return null;
    }

    public String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }

    public void printListHistory(ArrayList<SalaryHistory> lh) {
        if (lh.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.println("-------------Display Information Salary-----------");
        System.out.printf("| %-10s | %-15s | %-5s | %-15s | %-10s | %-20s |\n",
                "Code", "Name", "Age", "Salary", "Status", "Date");
        Collections.sort(lh);

        // Print history from first to last list
        for (SalaryHistory history : lh) {
            System.out.printf("| %-10s | %-15s | %-5d | %-15.2f | %-10s | %-20s |\n",
                    history.getId(),
                    history.getName(),
                    history.getAge(),
                    history.getSalary(),
                    history.getStatus(),
                    history.getDate());
        }
    }

}
