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
import View.Menu;

import java.util.ArrayList;

public class ProgramManagement extends Menu {

    static String[] mc = {"Experience", "Fresher", "InternShip", "Searching", "Exit"};
    CandidatesManagement cm = new CandidatesManagement();
    ArrayList<Candidate> candidates = new ArrayList<>();

    public ProgramManagement() {
        super("CANDIDATE MANAGEMENT SYSTEM", mc);
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                cm.createCandidate(candidates, 0);
                break;
            case 2:
                cm.createCandidate(candidates, 1);
                break;
            case 3:
                cm.createCandidate(candidates, 2);
                break;
            case 4:
                cm.searchCandidate(candidates);
                break;
            case 5:
                System.out.println("Program exit");
        }

    }
}
