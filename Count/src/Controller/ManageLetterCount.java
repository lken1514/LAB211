/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Model;
import View.Menu;
import java.util.*;

/**
 *
 * @author TRUNG KIEN
 */

public class ManageLetterCount extends Menu {

    Scanner sc = new Scanner(System.in);
    

    LetterCountModel lcm = new LetterCountModel();
    Model input = new Model();
    Validate validate = new Validate();

    public ManageLetterCount(){
        super("----Letter Count program----", new String[]{"Input content", "Word Count", "Letter Count","Exit program"});
    }
    

    @Override
    public void execute(int choice) {
        switch(choice){
            case 1:
                input = validate.inputValidateString("Enter your content: ");
                break;
            case 2:
                System.out.println("===Words Count===");
                Map<String, Integer> wordCount = lcm.countWords(input);
                lcm.displayWordCount(wordCount);

                break;
            case 3:
                System.out.println("===Letter Count===");
                Map<Character, Integer> letterCount = lcm.countCharacters(input);
                lcm.displayLetterCount(letterCount);

                break;
            case 4:
                System.out.println("Exited.");
                break;
            default:
                System.err.println("Invalid choice. Please try again.");
                break;

        }

    }
}


