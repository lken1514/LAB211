/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Contact;
import View.ContactView;
import utils.Validate;
import View.Menu;
import java.util.ArrayList;

/**
 *
 * @author TRUNG KIEN
 */
public class ContactManage extends Menu {

    Validate vl = new Validate();
    ArrayList<Contact> lc = new ArrayList<>();
    ContactView c = new ContactView();

    public ContactManage() {
        super("======= Contact program =======", new String[]{"Add a Contact", "Display all Contact", "Delete a Contact", "Exit"});
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                c.createContact(lc, "------- Add a Contact -------");
                break;
            case 2:
                c.printAllContact(lc, "------- Display all Contact -------");
                break;
            case 3:
                c.deleteContactByID(lc, "------- Delete a Contact -------");
                break;
            case 4:
                System.exit(0);
        }
    }
}
