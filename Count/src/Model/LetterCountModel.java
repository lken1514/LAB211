package Controller;
import Model.Model;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class LetterCountModel {
    public Map<String, Integer> countWords(Model inputString) {
        Map<String, Integer> wordCount = new HashMap<>();
        String input = inputString.getInputString(); 

        StringTokenizer tokenizer = new StringTokenizer(input);

        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        return wordCount;
    }

    public Map<Character, Integer> countCharacters(Model inputString) {
    Map<Character, Integer> characterCount = new HashMap<>();
    String input = inputString.getInputString();

    for (int i = 0; i < input.length(); i++) {
        char c = input.charAt(i);
        if (c != ' ') { 
            characterCount.put(c, characterCount.getOrDefault(c, 0) + 1);
        }
    }

    return characterCount;
}



    public void displayWordCount(Map<String, Integer> wordCount) {
        System.out.println("Word count: " + wordCount);
    }

    public void displayLetterCount(Map<Character, Integer> letterCount) {
        System.out.println("Letter count: " + letterCount);
    }
}
