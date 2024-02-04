/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package doctormanagement;

import Controller.DocManage;

/**
 *
 * @author TRUNG KIEN
 */
public class DoctorManagement {

    public static void main(String[] args) {
    try {
        DocManage d = new DocManage();
        d.run();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
