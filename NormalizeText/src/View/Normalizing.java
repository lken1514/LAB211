package View;

import Model.TextModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Normalizing {

    private List<TextModel> textModels;

    public Normalizing() {
        textModels = new ArrayList<>();
    }

    public void readAndDisplayFile(FileHandler fileHandler) {
        try {
            List<String> lines = fileHandler.readData();
            for (String line : lines) {
                textModels.add(new TextModel(line, null));
            }
            System.out.println("File read successfully. Content:");
            displayTextModels();
        } catch (IOException e) {
            System.err.println("Error reading data from FileHandler: " + e.getMessage());
        }
    }

    public void normalizeAndWrite(FileHandler fileHandler) {
        if (textModels.isEmpty()) {
            System.out.println("Please read the file first before normalization.");
            return;
        }

        List<String> normalizedTexts = new ArrayList<>();
        for (TextModel textModel : textModels) {
            String normalizedText = normalizeText(textModel.getInput());
            normalizedTexts.add(normalizedText);
        }

        try {
            fileHandler.writeData(normalizedTexts);
            System.out.println("Normalization successful. Content after normalization:");
            displayTextModels();
        } catch (IOException e) {
            System.err.println("Error writing normalized data to FileHandler: " + e.getMessage());
        }
    }

    public String normalizeText(String text) {
        text = oneSpaceNormal(text);
        text = signNormal(text);
        text = CapitalNormal(text);
        text = endDotNormal(text);
        text = quotesNormal(text);
        text = removeBlankLines(text);
        return text;
    }

    private String removeBlankLines(String text) {
        String[] paragraphs = text.split("\\s*\\n\\s*\\n\\s*"); // Tách chuỗi thành các đoạn văn bản

        StringBuilder result = new StringBuilder();
        for (String paragraph : paragraphs) {
            result.append(paragraph.trim()).append(System.getProperty("line.separator"));
        }

        return result.toString().trim();
    }

    private String oneSpaceNormal(String text) {
        return text.trim().replaceAll(" +", " ");
    }

    private String signNormal(String text) {
        char ch[] = {',', '.', ':'};
        for (char c : ch) {
            text = text.replace(" " + c, c + "");
            text = text.replace(c + " ", c + "");
            text = text.replace(c + "", c + " ");
        }
        return text;
    }

    public String firstUppercase(String text) {
        String[] lines = text.split(System.getProperty("line.separator"));
        StringBuilder result = new StringBuilder();

        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                line = line.toLowerCase();
                String firstLetter = line.substring(0, 1);
                String remainingLetters = line.substring(1);

                // Change the first letter to uppercase
                firstLetter = firstLetter.toUpperCase();
                // Join the two substrings
                line = firstLetter + remainingLetters;

                result.append(line).append(System.getProperty("line.separator"));
            }
        }

        return result.toString().trim();
    }

    private String CapitalNormal(String text) {
        text = text.toLowerCase();
        StringBuffer sb = new StringBuffer(text);

        for (int i = 0; i < sb.length() - 2; i++) {
            if (sb.charAt(i) == '.' && i + 2 < sb.length()) {
                char pos = sb.charAt(i + 2);
                sb.setCharAt(i + 2, Character.toUpperCase(pos));
            }
        }

        return sb.toString();
    }

    private String endDotNormal(String text) {
        return text.endsWith(".") ? text : text + ".";
    }

    private String quotesNormal(String text) {
        String regex = "([“])([\\S ]*)([”])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "$1" + matcher.group(2).trim() + "$3");
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public void normalizeAllTexts(FileHandler fileHandler) {
        try {
            fileHandler.readData();
        } catch (IOException e) {
            System.err.println("Error reading data from FileHandler: " + e.getMessage());
            return;
        }

        List<String> normalizedTexts = new ArrayList<>();

        for (TextModel textModel : textModels) {
            String normalizedText = normalizeText(textModel.getInput());
            normalizedTexts.add(normalizedText);
        }

        try {
            fileHandler.writeData(normalizedTexts);
        } catch (IOException e) {
            System.err.println("Error writing normalized data to FileHandler: " + e.getMessage());
        }
    }

    private void displayTextModels() {
        for (TextModel textModel : textModels) {
            System.out.println(textModel.getInput());
        }
    }
}
