package Controller;

import Model.TextModel;
import View.FileHandler;
import View.Menu;
import View.Normalizing;

public class NormalizeManagement extends Menu {

    private Normalizing txtView = new Normalizing();
    private TextModel txtModel = new TextModel("input.txt", "output.txt");
    private FileHandler fileHandler = new FileHandler();

    public NormalizeManagement() {
        super("Normalize Text", new String[]{"Load input file", "Normalize text", "Print output file", "Exit"});
    }

    @Override
public void execute(int n) {
    switch (n) {
        case 1:
            txtView.readAndDisplayFile(fileHandler);
            break;
        case 2:
            txtView.normalizeAllTexts(fileHandler);
            System.out.println("Text normalization completed.");
            break;
        case 3:
            txtView.normalizeAndWrite(fileHandler);
            break;
        case 4:
            System.out.println("Exit program.");
            break;
        default:
            System.out.println("Invalid input. Please try again.");
            break;
    }
}

}