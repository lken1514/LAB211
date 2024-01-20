/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author TRUNG KIEN
 */

import Model.Candidate;
import Model.Intern;
import Model.Fresher;
import Model.Experience;

import java.util.ArrayList;
import java.util.Scanner;

public class CandidatesManagement {
    Validate validate = new Validate();
    Scanner sc = new Scanner(System.in);

    public void createCandidate(ArrayList<Candidate> candidates, int type) {
        //loop until user don't want to create new candidate
        

        while (true) {
            System.out.print("Enter id: ");
            String id = validate.checkInputString();
            System.out.print("Enter first name: ");
            String firstName = validate.checkInputString();
            System.out.print("Enter last name: ");
            String lastName = validate.checkInputString();
            System.out.print("Enter birth date: ");
            String birthDate = validate.checkBirthDay();
            System.out.print("Enter address: ");
            String address = validate.checkInputString();
            System.out.print("Enter phone: ");
            String phone = validate.checkInputPhone();
            System.out.print("Enter email: ");
            String email = validate.checkInputMail();
            Candidate candidate = new Candidate(id, firstName, lastName,
                    birthDate, address, phone, email, type);
            //check id exist or not
            if (validate.checkIdExist(candidates, id)) {
                switch (type) {
                    case 0:
                        createExperience(candidates, candidate);
                        break;
                    case 1:
                        createFresher(candidates, candidate);
                        break;
                    case 2:
                        createIntern(candidates, candidate);
                        break;
                }
            } else {
                return;
            }
            System.out.print("Do you want to continue (Y/N): ");
            //check user want to create new candidate or not
            if (!validate.checkInputYN()) {
                return;
            }
        }
    }

    public void createExperience(ArrayList<Candidate> candidates, Candidate candidate) {

        System.out.print("Enter year of experience ");
        String yearExperience = validate.checkInputExperience(candidate.getBirthDay());
        System.out.print("Enter professional skill: ");
        String proSkill = validate.checkInputString();
        candidates.add(new Experience(candidate.getId(), candidate.getFirstName(), 
                candidate.getLastName(), candidate.getBirthDay(),
                candidate.getAddress(), candidate.getPhone(), candidate.getMail(), 
                candidate.getTypeOfCandidate(), yearExperience, proSkill));
        System.err.println("Create success.");

    }

    public void createFresher(ArrayList<Candidate> candidates, Candidate candidate) {

        System.out.print("Enter graduation time: ");
        String graduationTime = validate.checkInputDate(candidate.getBirthDay());
        System.out.print("Choose graduation rank: ");
        String graduationRank = validate.checkInputGraduationRank();
        System.out.print("Enter graduation school: ");
        String graduationSchool = validate.checkInputString();
        candidates.add(new Fresher(candidate.getId(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDay(),
                candidate.getAddress(), candidate.getPhone(), candidate.getMail(), candidate.getTypeOfCandidate(), graduationTime, graduationRank, graduationSchool));
        System.err.println("Create success.");

    }

    public void createIntern(ArrayList<Candidate> candidates, Candidate candidate) {

        System.out.print("Enter major: ");
        String major = validate.checkInputString();
        System.out.print("Enter semester: ");
        String semester = validate.checkInputString();
        System.out.print("Enter university: ");
        String university = validate.checkInputString();
        candidates.add(new Intern(candidate.getId(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDay(),
                candidate.getAddress(), candidate.getPhone(), candidate.getMail(), candidate.getTypeOfCandidate(), major, semester, university));

        System.err.println("Create success.");

    }

    //Search Candidate
    public void searchCandidate(ArrayList<Candidate> candidates) {
    System.err.println("CANDIDATE LIST");
    printListNameCandidate(candidates);
    System.out.print("Enter candidate name (First name or Last name): ");
    String nameSearch = validate.checkInputString();

    int typeCandidate = 0;
    do {
        try {
            System.out.println("===TYPE OF CANDIDATE===");
            System.out.println("0. Experience.");
            System.out.println("1. Fresher.");
            System.out.println("2. Internship.");
            System.out.print("\nEnter type of candidate: ");

            typeCandidate = Integer.parseInt(validate.checkInputIntLimit(0, 2));

            if (typeCandidate < 0 || typeCandidate > 2) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Invalid choice. Please type a number between 0 and 2!");
        }
    } while (typeCandidate < 0 || typeCandidate > 2);

    for (Candidate candidate : candidates) {
        if (candidate.getTypeOfCandidate() == typeCandidate
                && (candidate.getFirstName().toLowerCase().contains(nameSearch.toLowerCase())
                || candidate.getLastName().toLowerCase().contains(nameSearch.toLowerCase()))) {
            System.out.println(candidate.toString());
        }
    }
}

    
    
    public void printListNameCandidate(ArrayList<Candidate> candidates) {
    boolean experienceHeaderPrinted = false;
    boolean fresherHeaderPrinted = false;
    boolean internHeaderPrinted = false;
    boolean experienceCandidatesPrinted = false;
    boolean fresherCandidatesPrinted = false;
    boolean internCandidatesPrinted = false;

    System.out.println("List of candidates:");

    for (Candidate candidate : candidates) {
        if (candidate instanceof Experience) {
            if (!experienceHeaderPrinted) {
                System.out.println("===========EXPERIENCE CANDIDATE============");
                experienceHeaderPrinted = true;
            }
            System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            experienceCandidatesPrinted = true;
        } else if (candidate instanceof Fresher) {
            if (!fresherHeaderPrinted) {
                System.out.println("==========FRESHER CANDIDATE==============");
                fresherHeaderPrinted = true;
            }
            System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            fresherCandidatesPrinted = true;
        } else if (candidate instanceof Intern) {
            if (!internHeaderPrinted) {
                System.out.println("===========INTERN CANDIDATE==============");
                internHeaderPrinted = true;
            }
            System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            internCandidatesPrinted = true;
        }
    }

    if (!experienceCandidatesPrinted) {
        System.out.println("===========EXPERIENCE CANDIDATE============");
        System.out.println("Empty");
    }
    if (!fresherCandidatesPrinted) {
        System.out.println("==========FRESHER CANDIDATE==============");
        System.out.println("Empty");
    }
    if (!internCandidatesPrinted) {
        System.out.println("===========INTERN CANDIDATE==============");
        System.out.println("Empty");
    }
}


}
