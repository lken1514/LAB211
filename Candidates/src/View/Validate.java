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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Validate {

    private Scanner sc = new Scanner(System.in);

    private final String PHONE_VALID = "^\\d{10}\\d*$";
    private final String EMAIL_VALID = "^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$";

    public String checkInputIntLimit(int min, int max) {
        String input;
        do {
            System.out.print("(Between " + min + " and " + max + "): ");
            input = sc.nextLine();
        } while (!isValidNumber(input, min, max));

        return input;
    }

    private boolean isValidNumber(String input, int min, int max) {
        try {
            int number = Integer.parseInt(input);
            return number >= min && number <= max;
        } catch (NumberFormatException e) {
            System.err.println("Invalid input. Please enter a number.");
            return false;
        }
    }

    // Check user input string
    public String checkInputString() {
        // Loop until user input is correct
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public String checkInputDate(String birthDate) {
        while (true) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String graduationDateStr = checkInputString();
                Date graduationDate = dateFormat.parse(graduationDateStr);
                int graduationYear = getYear(graduationDate);
                int birth = Integer.parseInt(birthDate);
                int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                int ageAfterSchool = graduationYear - birth;
                if (graduationYear <= birth || ageAfterSchool <= 17 || graduationYear > currentYear) {
                    throw new ParseException("", 0);
                } else {
                    return dateFormat.format(graduationDate);
                }
            } catch (ParseException e) {
                System.err.println("Invalid date format. Please enter the date in the format dd/MM/yyyy and "
                        + "enter graduationYear >= 18 compare to your age.");
            }
        }
    }

    public String checkBirthDay() {
        while (true) {
            String result = sc.nextLine().trim();
            String regex = "^[0-9]{4}$";
            if (result.matches(regex)) {
                int birthYear = Integer.parseInt(result);
                int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                int age = currentYear - birthYear;
                if (birthYear < currentYear && age >= 18 && age <= 60) {
                    return result;
                } else {
                    System.err.println("Invalid input. Birth year cannot be in current or the future and age is from 18 to 60.");
                    System.out.print("Enter again: ");
                }
            } else {
                System.err.println("Invalid input. Please enter birth year with a length of 4 digits.");
                System.out.print("Enter again: ");
            }
        }
    }

    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    public String checkInputPhone() {
        // Loop until user input is correct
        while (true) {
            String result = checkInputString();
            // Check user input phone is valid
            if (result.matches(PHONE_VALID)) {
                return result;
            } else {
                System.err.println("Phone is a number with a minimum of 10 characters");
                System.out.print("Enter again: ");
            }
        }
    }

    public String checkInputMail() {
        // Loop until user input is correct
        while (true) {
            String result = checkInputString();
            // Check user input mail is valid
            if (result.matches(EMAIL_VALID)) {
                return result;
            } else {
                System.err.println("Email input invalid, the correct format is <account name>@.<domain>");
                System.out.println("Please enter email again: ");
            }
        }
    }

    // Check input graduation rank
    public String checkInputGraduationRank() {
        String[] rankOptions = {"Excellence", "Good", "Fair", "Poor"};

        for (int i = 0; i < rankOptions.length; i++) {
            System.out.println((i + 1) + ". " + rankOptions[i]);
        }

        while (true) {
            try {
                int choice = Integer.parseInt(checkInputString());
                if (choice >= 1 && choice <= rankOptions.length) {
                    return rankOptions[choice - 1];
                } else {
                    System.err.println("Invalid choice. Please enter a number between 1 and " + rankOptions.length + ".");
                    System.out.print("Enter again: ");
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a number.");
                System.out.print("Enter again: ");
            }
        }
    }

    // Check if id exists
    public boolean checkIdExist(ArrayList<Candidate> candidates, String id) {
        for (Candidate candidate : candidates) {
            if (candidate.getId().equalsIgnoreCase(id)) {
                System.err.println("Id exists.");
                return false;
            }
        }
        return true;
    }

    public boolean checkInputYN() {
        // Loop until user input is correct
        while (true) {
            String result = checkInputString();
            // Check user input y/Y or n/N
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    public String checkInputExperience(String birthDate) {
        try {
            int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
            int birthYear = Integer.parseInt(birthDate);
            int age = yearCurrent - birthYear;

            int yearExperience = 0;

            do {
                String yearExperienceString = checkInputIntLimit(1, 100);

                try {
                    yearExperience = Integer.parseInt(yearExperienceString);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input. Please enter a number.");
                    // Optionally, you may want to continue the loop or return an error message.
                    continue;
                }

                if (yearExperience > age) {
                    System.err.println("Experience must be smaller than age");
                }
            } while (yearExperience > age);

            return "Years of experience: " + yearExperience;
        } catch (NumberFormatException e) {
            System.err.println("Invalid birth year format. Please enter a valid year.");
            return null;
        }
    }
}
