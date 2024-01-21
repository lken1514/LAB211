/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

/**
 *
 * @author TRUNG KIEN
 */
import Model.Report;
import Model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Validate {

    Scanner sc = new Scanner(System.in);

    //check user input number limit
    public int checkInputIntLimit(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in range [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    //check user input course
    public String checkInputCourse() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //check input course in java/ .net/ c/c++
            if (result.equalsIgnoreCase("java")
                    || result.equalsIgnoreCase(".net")
                    || result.equalsIgnoreCase("c/c++")) {
                return result;
            }
            System.err.println("There are only three courses: Java, .Net, C/C++");
            System.out.print("Enter again: ");
        }
    }

//check user input String
    public String checkInputString() {
        // Loop until non-empty input is provided
        while (true) {
            String result = sc.nextLine().trim();

            // Check if input is not empty
            if (!result.isEmpty()) {
                return result;
            } else {
                System.err.println("Input cannot be empty. Please enter again: ");
            }
        }
    }

//check user input update / delete
    public boolean checkInputUD() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //return true if user input u/U
            if (result.equalsIgnoreCase("U")) {
                return true;
            }
            //return false if user input d/D
            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.err.println("Please input u/U or d/D.");
            System.out.print("Enter again: ");
        }
    }

    //check student exist
    public boolean checkStudentExist(ArrayList<Student> ls, String id, String studentName, String semester, String courseName) {
        int size = ls.size();
        for (Student student : ls) {
            if (id.equalsIgnoreCase(student.getID())
                    && studentName.equalsIgnoreCase(student.getStudentName())
                    && semester.equalsIgnoreCase(student.getSemester())
                    && courseName.equalsIgnoreCase(student.getCourseName())) {
                return false;
            }
        }
        return true;
    }

    //check id and name exist
    public boolean checkIdExist(ArrayList<Student> ls, String id, String name) {
        for (Student student : ls) {
            if (id.equalsIgnoreCase(student.getID())
                    && !name.equalsIgnoreCase(student.getStudentName())) {
                return false;
            }
        }
        return true;
    }

    //check report exist
    public boolean checkReportExist(ArrayList<Report> lr, String name,
            String course, int total) {
        for (Report report : lr) {
            if (name.equalsIgnoreCase(report.getStudentName())
                    && course.equalsIgnoreCase(report.getCourseName())
                    && total == report.getTotalCourse()) {
                return false;
            }
        }
        return true;
    }

//check user input Yes/No
    public boolean checkInputYN() {
        //loop until user input correct
        while (true) {
            String input = checkInputString();
            if (input.equalsIgnoreCase("Y")) {
                return true;
            } else if (input.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.err.println("Must input Y or N to select option");
            }
        }

    }

    public String chooseSemester() {
        System.out.println("Choose semester:");
        System.out.println("1. Spring");
        System.out.println("2. Summer");
        System.out.println("3. Fall");
        System.out.print("Enter your choice: ");
        int semesterChoice = checkInputIntLimit(1, 3);

        switch (semesterChoice) {
            case 1:
                return "Spring";
            case 2:
                return "Summer";
            case 3:
                return "Fall";
            default:
                System.err.println("Invalid semester choice. Defaulting to Spring.");
                return "Spring";
        }
    }

    public String chooseCourse() {
        System.out.println("Choose course:");
        System.out.println("1. Java");
        System.out.println("2. .NET");
        System.out.println("3. C/C++");
        System.out.print("Enter your choice: ");
        int courseChoice = checkInputIntLimit(1, 3);

        switch (courseChoice) {
            case 1:
                return "Java";
            case 2:
                return ".NET";
            case 3:
                return "C/C++";
            default:
                System.err.println("Invalid course choice. Defaulting to Java.");
                return "Java";
        }
    }

    //check user change or not
    public boolean checkChangeInfomation(Student student, String id,
            String name, String semester, String course) {
        if (id.equalsIgnoreCase(student.getID())
                && name.equalsIgnoreCase(student.getStudentName())
                && semester.equalsIgnoreCase(student.getSemester())
                && course.equalsIgnoreCase(student.getCourseName())) {
            return false;
        }
        return true;
    }

}
