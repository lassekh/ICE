package Utility;

import User.AccountHandler;

import java.util.List;
import java.util.Scanner;

public class UI {

    private Scanner scanner = new Scanner(System.in);

    public void displayMessage(String msg){
        System.out.println(msg);
    }
    public String getInput(String msg){
        displayMessage(msg);
        String input = scanner.nextLine();
        return input;
    }

    public void displayMenu(List<String> menuItems){
        int counter = 1;

        displayMessage("See the menu below, for options");
        for(String s: menuItems){
            displayMessage(counter + ") " + s);
            counter++;
        }
    }
}
