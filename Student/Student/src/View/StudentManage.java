/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author TRUNG KIEN
 */
import Library.Validate;
import Model.Report;
import Model.Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentManage extends ArrayList<Student> {

    Validate validate = new Validate();
    String path = Paths.get("").toAbsolutePath().toString();   //lấy địa chỉ tuyệt đối
    String filename = path + "/src/Text/text.txt";       //thêm địa chỉ đuôi
    private Scanner sc = new Scanner(System.in);

    public StudentManage() {
        ArrayList<Student> st = new ArrayList<>();
    }

    public void inputData() {
        try {
            FileWriter fw = new FileWriter(filename); //FileWriter fw = new FileWriter(filename, true); để viết thêm vào file mà ko xóa dữ liệu
            BufferedWriter bw = new BufferedWriter(fw);
            //Có thể rút gọn 2 dòng trên thành:
            //  BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            for (Student bk : this) {
                bw.write(bk.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.err.println("Can't find that file!");
        }
    }

    public void loadData() {
        try {
            this.clear();    //clear lại arr trước khi load dữ liệu mới (Tránh lặp dữ liệu)
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            int count = 0;
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] data = line.split(";");    //Chia dữ liệu ra từng biến khác nhau để nhận
                if (data.length == 4) {  //check thử tính đầy đủ của dữ liệu, loại bỏ trường hợp trống
                    String ID = data[0].split("=")[1];
                    String studentName = data[1].split("=")[1];
                    String semester = data[2].split("=")[1];
                    String courseName = data[3].split("=")[1];
                    if (studentName != null && ID != null) {
                        this.add(new Student(ID, studentName, semester, courseName));
                        count++;
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Some thing wrong!");
        }
    }

    public void createStudent(int count, ArrayList<Student> ls) {
        Student st = new Student();
        String id, name, semester, course;
        while (true) {
            System.out.print("Do you want to add another student? (Y/N): ");
            if (!validate.checkInputYN()) {
                return;
            }

            //loop until user input not duplicate
            while (true) {
                System.out.print("Enter id: ");
                id = validate.checkInputString();
                System.out.print("Enter name student: ");
                name = validate.checkInputString();
                if (!validate.checkIdExist(ls, id, name)) {
                    System.err.println("Id has exist student. Please re-input.");
                    continue;
                }
                semester = validate.chooseSemester();
                course = validate.chooseCourse();

                // Check if the student exists or not
                if (validate.checkStudentExist(this, id, name, semester, course)) {
                    this.add(new Student(id, name, semester, course));
                    count++;
                    System.out.println("Add student success.");
                    break;
                }
                System.err.println("Duplicate.");
            }
            /*st.setID(id);
            st.setStudentName(name);
            st.setSemester(semester);
            st.setCourseName(course);
            this.add(st);*/
            this.inputData();
            System.out.println("Student " + st.getID() + " has been added!");
        }
    }

    public void findAndSort(ArrayList<Student> ls) {
        //check list empty
        if (ls.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        ArrayList<Student> listStudentFindByName = listStudentFindByName(ls);
        if (listStudentFindByName.isEmpty()) {
            System.err.println("Not exist.");
        } else {
            Collections.sort(listStudentFindByName);
            System.out.printf("%-15s | %-20s | %-15s \n", "Student name", "semester", "Course Name");
            //loop from first to last element of list student
            for (Student student : listStudentFindByName) {
                System.out.println(student.toString());
            }
        }
    }

    //List student found by name
    public ArrayList<Student> listStudentFindByName(ArrayList<Student> ls) {
        ArrayList<Student> listStudentFindByName = new ArrayList<>();
        System.out.print("Enter name to search: ");
        String name = validate.checkInputString().toLowerCase();
        for (Student student : ls) {
            // Convert student name to lowercase for case-insensitive comparison
            if (student.getStudentName().toLowerCase().contains(name)) {
                listStudentFindByName.add(student);
            }
        }
        return listStudentFindByName;
    }

    //Allow user update and delete
    public void updateOrDelete() {
        Student student = findStudentById();
        if (student == null) {
            System.err.println("Student not found.");
            return;
        }
        System.out.println("Do you want to update (U) or delete (D) student? ");
        System.out.println("Enter your choice (U or D):");
        String userInput = validate.checkInputString();
        while (true) {
            if (userInput.equalsIgnoreCase("U")) {
                // Update student information
                System.out.print("Enter new ID: ");
                String newId = validate.checkInputString();
                System.out.print("Enter new name: ");
                String newName = validate.checkInputString();
                System.out.print("Enter new semester: ");
                String newSemester = validate.checkInputString();
                System.out.print("Enter new course: ");
                String newCourse = validate.checkInputCourse();

                // Update student information
                student.setID(newId);
                student.setStudentName(newName);
                student.setSemester(newSemester);
                student.setCourseName(newCourse);

                System.out.println("Student information updated successfully.");
                inputData(); // Update data in the file
                break;
            } else if (userInput.equalsIgnoreCase("D")) {
                // Delete the student
                this.remove(student);
                System.out.println("Student deleted successfully.");
                this.inputData(); // Update data in the file
                break;
            } else {
                System.err.println("Invalid choice. Please enter U or D.");
            }
        }
    }

// Find a student by ID
    private Student findStudentById() {
        System.out.print("Enter student ID to update/delete: ");
        String id = validate.checkInputString();

        for (Student student : this) {
            if (id.equalsIgnoreCase(student.getID())) {
                return student;
            }
        }
        return null;
    }

// Display all students
    public void displayAll() {
        if (this.isEmpty()) {
            System.err.println("List empty.");
            return;
        }

        System.out.printf("%-10s | %-20s | %-15s | %-15s \n", "Number", "Student name", "semester", "Course Name");
        int count = 1;

        for (Student student : this) {
            System.out.printf("%-10d | %-20s | %-15s | %-15s \n", count, student.getStudentName(),
                    student.getSemester(), student.getCourseName());
            count++;
        }

        // Optional: Return a student based on user input
        /*Student selectedStudent = getStudentByUserInput();
        if (selectedStudent != null) {
            System.out.println("Selected student: " + selectedStudent.toString());
        }*/
        System.out.println(">> Total: " + this.size() + " students");
    }

// Optional: Allow user to select a student from the displayed list
    /*private Student getStudentByUserInput() {
        System.out.print("Enter the number of the student: ");
        int choice = validate.checkInputIntLimit(1, this.size());

        return this.get(choice - 1);
    }*/
    //Get list student find by id
    public ArrayList<Student> getListStudentById(String id) {
        ArrayList<Student> getListStudentById = new ArrayList<>();
        for (Student student : this) {
            if (id.equalsIgnoreCase(student.getID())) {
                getListStudentById.add(student);
            }
        }
        return getListStudentById;
    }

    //Print report
    // Modify the report method in the StudentManage class
// Modify the report method in the StudentManage class
    public void report(ArrayList<Student> ls) {
        Map<String, Integer> reports = new HashMap<>();
        for (Student student : ls) {
            String key = student.getID() + "#" + student.getStudentName() + "|" + student.getCourseName();
            if (reports.containsKey(key)) {
                int total = reports.get(key);
                reports.put(key, total + 1);
            } else {
                reports.put(key, 1);
            }

        }
        for (String key : reports.keySet()) {
            System.out.println(key.split("#")[1] + "|" + reports.get(key));
        }
    }

}
