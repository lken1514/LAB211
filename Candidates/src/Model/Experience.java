/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author TRUNG KIEN
 */
public class Experience extends Candidate {

    private String expInYear;
    private String proSkill;

    public Experience() {
    }

    public Experience(String id, String firstName, String lastName, String birthDay, String address, String phone, String mail, int typeOfCandidate, String expInYear, String proSkill) {
        super(id, firstName, lastName, birthDay, address, phone, mail, typeOfCandidate);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public String getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(String expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
}
