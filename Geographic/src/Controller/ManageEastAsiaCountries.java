package Controller;

import Model.Country;
import View.Menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ManageEastAsiaCountries extends Menu {

    Scanner sc = new Scanner(System.in);
    Validate vl = new Validate();
    ArrayList<Country> countries = new ArrayList<>();


    public ManageEastAsiaCountries(){
        super("============ MENU ============", new String[]{"Enter the information for 11 countries in Southeast Asia.", "Display already information.",
                "Search the country according to the entered country's name.", "Display the information increasing with the country name.", "Exit"} );

    }

    @Override
    public void execute(int choice) {

        switch (choice){

            case 1:
                addCountry(countries, "---------Add Country---------");
                break;
            case 2:
                displayCountry(countries, "--------Display Country-------");
                break;
            case 3:
                searchByName(countries, "---------Search Country---------");
                break;
            case 4:
                displayCountrySorted(countries, "---------Display Country Sorted---------");
                break;
            case 5: System.exit(0);
        }


    }
    //add country by user
    public void addCountry(ArrayList<Country> countries, String msg){
        int userChoice;
        do {
            System.out.println("Enter code: ");
            String countryCode = vl.checkInputString();
            if(!checkCountryCodeExist(countries, countryCode)){
                System.err.println("Country code exist!");
                return;
            }
            System.out.println("Enter country name: ");
            String countryName = vl.checkInputString();
            System.out.println("Enter total area: ");
            double countryArea = vl.checkInputDouble();
            System.out.println("Enter terrain of country: ");
            String countryTerrain = vl.checkInputString();
            countries.add(new Country(countryCode, countryName, countryArea, countryTerrain));
            System.out.println("Add country successfully! ");

            System.out.println("Do you want to continue add another country?");
            System.out.println("Press 1 to continue add country! || Any others number to end function!");
            userChoice = sc.nextInt();

        }while(userChoice == 1);
    }

    //display country
    public void displayCountry(ArrayList<Country> countries, String msg){
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total area", "Terrain");
        for (Country c: countries){
            c.display();
        }
    }

    //display country sort by name
    public void displayCountrySorted(ArrayList<Country> countries, String msg){
        Collections.sort(countries);
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total area", "Terrain");
        for (Country c: countries){
            c.display();
        }
    }

    //Search country by name
    public void searchByName(ArrayList<Country> countries, String msg){
        System.out.println("Enter country name to search: ");
        String countryName = vl.checkInputString();
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total area", "Terrain");
        for (Country c: countries){
            if (c.getCountryName().equalsIgnoreCase(countryName)){
                c.display();
            }
        }
    }

    //Check Country Code Exist
    public boolean checkCountryCodeExist(ArrayList<Country> countries, String countryCode){
        for (Country c: countries){
            if (c.getCountryCode().equalsIgnoreCase(countryCode)){
                return false;
            }
        }
        return true;

    }
}
