package Utility;

import java.util.List;
import java.util.Scanner;

public class UI {

    private Scanner scanner = new Scanner(System.in);

    public void displayMessage(String msg) {
        System.out.println(msg);
    }

    public String getInput(String msg) {
        displayMessage(msg);
        String input = scanner.nextLine();
        return input;
    }

    public int displayMenu(List<String> menuItems) {
        int counter = 1;
        int option = 0;


        displayMessage("Choose one of the options below");
        for (String s : menuItems) {
            displayMessage(counter + ") " + s);
            counter++;
        }
        boolean invalidOption = true;
        while (invalidOption) {
            try {
                option = Integer.parseInt(scanner.nextLine());
                if (option < 1 || option > menuItems.size()) {
                    displayMessage("Please type a number between 1 and " + menuItems.size());
                } else {
                    invalidOption = false;
                }
            } catch (NumberFormatException e) {
                displayMessage("Please type a number between 1 and " + menuItems.size());
            }
        }
        return option;
    }
}
