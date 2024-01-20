/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author TRUNG KIEN
 */
public class Candidate {

    private String id;
    private String firstName;
    private String lastName;
    private String birthDay;
    private String address;
    private String phone;
    private String mail;
    private int typeOfCandidate;

    public Candidate() {
    }

    public Candidate(String id, String firstName, String lastName, String birthDay, String address, String phone, String mail, int typeOfCandidate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.address = address;
        this.phone = phone;
        this.mail = mail;
        this.typeOfCandidate = typeOfCandidate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getTypeOfCandidate() {
        return typeOfCandidate;
    }

    public void setTypeOfCandidate(int typeOfCandidate) {
        this.typeOfCandidate = typeOfCandidate;
    }

    @Override
    public String toString() {
        return this.firstName + this.lastName + " | " + this.birthDay + " | "
                + this.address + " | " + this.phone + " | " + this.mail + " | " 
                + typeOfCandidate;
    }
}
