/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author TRUNG KIEN
 */
import Model.Doctor;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManageDoctor {

    String fileInput = "DoctorData.txt";
    Inputter i = new Inputter();
    private final Scanner sc = new Scanner(System.in);
    public List<Doctor> doctorsList = new ArrayList<>();

    public void addDoctor() {
        try {
            String code, name, specialization;
            int availability;
            int userChoice;
            System.out.println("-------------Add Doctor---------------");
            do {

                code = i.createCode("Enter Doctor code: ", this);
                name = i.inputString("Enter Doctor name: ");
                specialization = i.inputString("Enter specialization: ");
                availability = i.inputInt("Enter Availability: ");
                Doctor doctor = new Doctor(code, name, specialization, availability);
                doctorsList.add(doctor);
                System.out.println("Add Doctor successful!");

                System.out.println("Do you want to continue add another doctor?");
                System.out.println("Press 1 to continue add doctor! || Any others number to end function!");
                userChoice = sc.nextInt();

            } while (userChoice == 1);
            writeFile();
            System.out.println("Add successful");
        } catch (IOException ex) {
            Logger.getLogger(ManageDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateDoctor() {
        try {
            String code, name, specialization;
            int availability;
            System.out.println("-------------Update Doctor---------------");
            code = i.inputCode("Enter code: ", this);
            name = i.inputString("Enter Doctor name: ");
            specialization = i.inputString("Enter specialization: ");
            availability = i.inputInt("Enter Availability: ");
            for (Doctor doctor : doctorsList) {
                if (doctor.getCode().equals(code)) {
                    doctor.setName(name);
                    doctor.setSpecialization(specialization);
                    doctor.setAvailability(availability);
                }
            }
            writeFile();
            System.out.println("Update success");
        } catch (IOException ex) {
            Logger.getLogger(ManageDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteDoctor() {
        try {
            String code = i.inputCode("Enter Doctor code: ", this);

            Doctor foundDoctor = findDoctorByCode(code);
            doctorsList.remove(foundDoctor);

            writeFile();
            System.out.println("Delete success");
        } catch (IOException ex) {
            Logger.getLogger(ManageDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Doctor findDoctorByCode(String code) {
        for (Doctor doctor : doctorsList) {
            if (doctor.getCode().equals(code)) {
                return doctor;
            }
        }
        return null;
    }

    public void searchDoctor() {
        System.out.println("-------------Search---------------");
        String nameToSearch = i.inputString("Enter doctor name: ");

        System.out.println("Search List");
        System.out.printf("%-6s | %-22s | %-18s | %-13s \n",
                "docID", "Name", "Specialization", "Availability");

        boolean found = false;
        for (Doctor doctor : doctorsList) {
            if (doctor.getName().toLowerCase().contains(nameToSearch.toLowerCase())) {
                System.out.printf("%-6s | %-22s | %-18s | %-13s \n",
                        doctor.getCode(), doctor.getName(), doctor.getSpecialization(),
                        doctor.getAvailability());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No doctors found with the provided name.");
        }
    }

    public void readFile() {
        System.out.println("----------Read File---------");
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileInput));
            String line = null;

            System.out.println("File data: ");

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(";");

                if (parts.length == 4) {

                    String code = parts[0].split("=")[1].trim();
                    String name = parts[1].split("=")[1].trim();
                    String specialization = parts[2].split("=")[1].trim();
                    int availability = Integer.parseInt(parts[3].split("=")[1]);

                    //System.out.println(line);
                    Doctor doctor = new Doctor(code, name, specialization, availability);

                    if (!isExistedCode(doctor.getCode())) {
                        doctorsList.add(doctor);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileInput + " not found ");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void writeFile() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileInput));
        try {

            for (Doctor doctor : doctorsList) {
                bw.write(doctor.getCode() + "," + doctor.getName() + "," + doctor.getSpecialization() + "," + doctor.getAvailability() + "\n");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            bw.close();
        }

    }

    public boolean isExistedCode(String code) {

        for (Doctor doctor : doctorsList) {
            if (doctor.getCode().equals(code)) {
                return true;
            }
        }

        return false;
    }

    public void display() {
        System.out.println("List of doctors:");

        if (doctorsList.isEmpty()) {
            System.out.println("Empty list.");
        } else {
            System.out.printf("%-6s | %-22s | %-18s | %-13s \n",
                    "docID", "Name", "Specialization", "Availability");
            for (Doctor doc : doctorsList) {
                System.out.printf("%-6s | %-22s | %-18s | %-13s \n",
                        doc.getCode(), doc.getName(), doc.getSpecialization(),
                        doc.getAvailability());
            }
            System.out.println(">>Total: " + doctorsList.size() + " doctors");
        }
    }

}
