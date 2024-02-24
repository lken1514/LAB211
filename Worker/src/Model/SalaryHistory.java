/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.Worker;

/**
 *
 * @author TRUNG KIEN
 */
public class SalaryHistory extends Worker implements Comparable<SalaryHistory> {

    private String status;
    private String date;

    public SalaryHistory() {
        super();
    }

    public SalaryHistory(String status, String date, String id, String name, int age, double salary, String workLocation) {
        super(id, name, age, salary, workLocation);
        this.status = status;
        this.date = date;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int compareTo(SalaryHistory t) {
        return this.getId().compareTo(t.getId());
    }

}
