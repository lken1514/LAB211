/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import utils.Validate;
import Model.Contact;
import java.util.ArrayList;
import utils.Inputter;

/**
 *
 * @author TRUNG KIEN
 */
public class ContactView {

    Validate vl = new Validate();
    Inputter input = new Inputter();

    private int currentMaxId = 0;

    public void createContact(ArrayList<Contact> lc, String msg) {
        currentMaxId++;
        String firstName = input.getStringInput("Enter first name: ");

        String lastName = input.getStringInput("Enter last name: ");

        String group = input.getStringInput("Enter group: ");

        String address = input.getStringInput("Enter address: ");

        String phone = input.getPhoneInput("Enter phone: ");

        // Assign the next available ID to the new contact
        int ID = currentMaxId;

        lc.add(new Contact(ID, firstName + lastName, group, address, phone, firstName, lastName));
        System.err.println("Add successful.");
    }

    //allow user display all contact
    public void printAllContact(ArrayList<Contact> lc, String msg) {
        System.out.printf("%-5s%-30s%-20s%-20s%-20s%-20s%-20s\n", "Id", "Name",
                "First name", "Last name", "Group", "Address", "Phone");
        if (lc.isEmpty()) {
            System.out.println("The contact list is empty. ");
        }
        //print information of contact from first to last list contact
        for (Contact contact : lc) {
            System.out.printf("%-5d%-30s%-20s%-20s%-20s%-20s%-20s\n",
                    contact.getId(), contact.getFullName(),
                    contact.getFirstName(), contact.getLastName(),
                    contact.getGroup(), contact.getAddress(), contact.getPhone());
        }
    }

    //allow user delete contact
    public void deleteContactByID(ArrayList<Contact> lc, String msg) {
        System.out.print("Enter " + msg + ": ");

// Loop until a valid integer is entered
        while (true) {
            try {
                String inputStr = input.getIntInputWithRange("Enter " + msg + " again: ", Integer.MIN_VALUE, Integer.MAX_VALUE) + "";

                if (vl.isValidInt(inputStr)) {
                    int idDelete = Integer.parseInt(inputStr);
                    Contact contactDelete = getContactById(lc, idDelete);

                    if (contactDelete == null) {
                        System.err.println("Not found contact.");
                        return;
                    } else {
                        lc.remove(contactDelete);
                    }

                    System.err.println("Delete successful.");
                    break;
                } else {
                    System.err.println("Invalid input. Please enter a valid integer.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a valid integer.");
            }
        }

    }

    //get contact by id
    public Contact getContactById(ArrayList<Contact> lc, int idDelete) {
        for (Contact contact : lc) {
            if (contact.getId() == idDelete) {
                return contact;
            }
        }
        return null;
    }
}
