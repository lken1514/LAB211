/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author TRUNG KIEN
 */
public class Fresher extends Candidate {

    private String graduationDate;
    private String graduationRank;

    private String education;

    public Fresher() {
    }

    public Fresher(String id, String firstName, String lastName, String birthDay, String address, String phone, String mail, int typeOfCandidate, String graduationDate, String graduationRank, String education) {
        super(id, firstName, lastName, birthDay, address, phone, mail, typeOfCandidate);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
    
    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

}
