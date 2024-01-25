package View;

import Model.TextModel;
import java.io.*;
import java.util.*;

public class FileHandler {
    private String filename;
    private String normalizedText;
    private TextModel textModel = new TextModel();


    public List<String> readData() throws IOException {
    List<String> lines = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(textModel.getInput()))) {
        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
    }
    return lines;
}

public void writeData(List<String> normalizedTexts) throws IOException {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(textModel.getOutput()))) {
        for (String line : normalizedTexts) {
            bw.write(line);
            bw.newLine();
        }
    } catch (IOException ioException) {
        throw new IOException("An error occurred while writing to the output file", ioException);
    }
}

}


