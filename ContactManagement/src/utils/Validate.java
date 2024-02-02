package utils;

import java.util.Scanner;

public class Validate {

    private final String VALID_PHONE = "[(]?[0-9]{3}[)]?[-. ]?[0-9]{3}[-. ]?[0-9]{4}"
            + "|[0-9]{3}[-][0-9]{3}[-][0-9]{4}[ a-z0-9]+";

    public boolean isValidIntRange(int value, int min, int max) {
        return value >= min && value <= max;
    }
    
    public boolean isValidInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isValidDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isValidOperator(String input) {
        return input.matches("[+\\-*/^=]");
    }

    public boolean isValidString(String input) {
        return !input.trim().isEmpty();
    }

    public boolean isValidPhone(String input) {
        return input.matches(VALID_PHONE);
    }
}

