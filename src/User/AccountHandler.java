package User;

import Utility.DBConnector;
import Utility.DBUser;
import Utility.UI;

import java.util.*;

public class AccountHandler {

    private Set<Account> accounts = new HashSet<Account>() {
    };
    //Mail instance variabel
    private String email;
    //Password instance variabel
    private String password;
    //Scanner class to get information from the user
    private Scanner scanner;

    private Account account;

    private AccountHandler accountHandler;

    private UI ui = new UI();
    private DBUser DB = new DBUser();

    public AccountHandler() {

    }

    public void loginOrCreateUser() {
        List<String> mainMenu = new ArrayList<>();
        mainMenu.add("Create a user");
        mainMenu.add("Login");
        ui.displayMenu(mainMenu);
        int input = Integer.parseInt(ui.getInput("Type number:"));

        boolean inputValidator = true;
        while (inputValidator) {
            try {
                if (input == 1) {
                    createAccount();
                    inputValidator = false;
                } else if (input == 2) {
                    loginForm();
                    inputValidator = false;
                } else {
                    input = Integer.parseInt(ui.getInput("Invalid input. Please enter either 1 or 2."));
                }
            } catch (NumberFormatException e) {
                ui.getInput("You did not type a number. Please try again:"); // Clear the invalid input from the scanner
            }
        }
    }


    public String createMail() {
        boolean isValidEmail = false;
        while (!isValidEmail) {
            String inputEmail = ui.getInput("Enter your email address. It must end with .dk or .com: ");
            if (inputEmail.contains("@") && (inputEmail.endsWith(".com") || inputEmail.endsWith(".dk"))) {
                email = inputEmail;
                return email;
            } else {
                System.out.println("Your inout is invalid. Please try again.");
            }
        }
        return null;
    }

    public String createPassword() {
        boolean inputValidPassword = false;
        while (!inputValidPassword) {
            String inputPassword = ui.getInput("Enter a password. It must contain at least 5 characters: ");
            if (inputPassword.length() >= 5) {
                password = inputPassword;
                return password;
            } else {
                System.out.println("Not correct! Try again");
            }
        }
        return null;
    }

    public void loginForm() {
        email = ui.getInput("Enter your email: ");
        password = ui.getInput("Enter your password: ");
        if (login(email, password)) {
            System.out.println("Account with email " + email + " is now logged in.");
        }
    }

    public boolean login(String email, String password) {
        for (Account account : accounts) {
            if (account.getEmail().equalsIgnoreCase(email) && account.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    /*
    public void createAccount() {
        account = new Account(createMail(), createPassword());
        accounts.add(account);

        System.out.println(account);

    }

     */
    public void createAccount() {
        boolean isValidEmail = false;
        while (!isValidEmail) {
            String inputEmail = ui.getInput("Enter your email address. It must end with .dk or .com: ");

            Set<Account> setOfAccounts = DB.readUserData();
            boolean emailExists = false;
            for (Account account : setOfAccounts) {
                if (account.getEmail().equalsIgnoreCase(inputEmail)) {
                    emailExists = true;
                    break;
                }
            }

            if (emailExists) {
                ui.displayMessage("This email is already used. Try another email");
            } else {
                if (inputEmail.contains("@") && (inputEmail.endsWith(".com") || inputEmail.endsWith(".dk"))) {
                    email = inputEmail;
                    isValidEmail = true;
                } else {
                    System.out.println("Your input is invalid. Please try again.");
                }
            }
        }
        boolean isValidPassword = false;
        while (!isValidPassword) {
            String inputPassword = ui.getInput("Enter a password. It must contain at least 5 characters: ");
            if (inputPassword.length() >= 5) {
                password = inputPassword;
                isValidPassword = true;
            } else {
                System.out.println("Not correct! Try again");
            }
        }
        DB.saveUser(email, password);
        ui.displayMessage("Congratulation! Your account has been registered successfully.");
    }
}
