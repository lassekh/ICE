package Utility;

import User.AccountHandler;

import java.util.List;
import java.util.Scanner;

public class UI {

    private Scanner scanner;
    private AccountHandler accountHandler = new AccountHandler();


    public void displayMessage(String msg){
        System.out.println(msg);
    }
    public String getInput(String msg){
        displayMessage(msg);
        String input = scanner.nextLine();
        return input;
    }

    public void displayMenu(List<String> msg){
        int counter = 1;

        displayMessage("Please choose one of the following options");
        for(String s: msg){
            System.out.println(counter + s);
            counter++;
        }
    }

    public void loginMenu() {
        scanner = new Scanner(System.in);

        System.out.println("Enter your email: ");
        String email = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        boolean loggedIn = accountHandler.login(email, password);

        if (loggedIn) {
            System.out.println("Account with email " + email + " is now logged in.");
        }
    }
}
