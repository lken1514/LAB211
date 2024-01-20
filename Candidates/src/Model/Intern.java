/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author TRUNG KIEN
 */
public class Intern extends Candidate{
    private String major;
    private String Semester;
    private String universityName;

    public Intern() {
    }

    public Intern(String id, String firstName, String lastName, String birthDay, String address, String phone, String mail, int typeOfCandidate, String major, String semester, String universityName) {
        super(id, firstName, lastName, birthDay, address, phone, mail, typeOfCandidate);
        this.major = major;
        Semester = semester;
        this.universityName = universityName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}

