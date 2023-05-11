package User;

import java.util.Scanner;
import java.util.Set;

public class AccountHandler {

    //private Set<Account> accounts = new Set<Account>(){};
    //Mail instance variabel
    private String mail;
    //Password instance variabel
    private String password;
    //Scanner class to get information from the user
    private Scanner scanner = new Scanner(System.in);

    public AccountHandler() {
        loginOrCreateUser();
    }

    public void loginOrCreateUser() {
        System.out.println("Hi! Which of the following options, do you want to proceed with?");
        System.out.println("1) Create a user");
        System.out.println("2) Login");
        System.out.println("Please type your option below: ");

        boolean inputValidator = true;
        while (inputValidator) {
            try {
                int input = scanner.nextInt();
                if (input == 1) {
                    //INPUT CREATE USER METHOD
                    inputValidator = false;
                } else if (input == 2) {
                    //INPUT LOGIN METHOD
                    inputValidator = false;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("I'm sorry.. I didn't understand that. Please try again.");
            }
        }
    }


    private String setMail() {
        boolean inputValidator = true;
        System.out.println("What's your e-mail?");
        System.out.println("(Your e-mail must either end with .dk or .com)");
        while (inputValidator) {
            String input = scanner.nextLine();
            if (input.length() > 5 && input.contains("@") && (input.contains(".com")) || input.contains(".dk")) {
                this.mail = input;
                inputValidator = false;
                return input;
            } else {
                System.out.println("Not correct! Try again");
            }
        }
        return "";
    }

    private String setPassword() {
        boolean inputValidator = true;
        System.out.println("Which passord would you like to create?");
        System.out.println("Must be at least 5 long");
        while (inputValidator) {
            String input = scanner.nextLine();
            if (input.length() >= 5) {
                this.password = input;
                inputValidator = false;
                return input;
            } else {
                System.out.println("Not correct! Try again");
            }
        }
        return null;
    }


    public void createAccount() {
        String mail = setMail();
        String password = setPassword();
        Account account = new (setMail(), setPassword());
        accounts.add(account);

    }

}
