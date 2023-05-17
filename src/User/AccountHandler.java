package User;

import Utility.DBUser;
import Utility.UI;

import java.util.*;

public class AccountHandler {

    private Set<Account> accounts = new HashSet<>();
    //Mail instance variabel
    private String email;
    //Password instance variabel
    private String password;
    private Account onlineAccount;
    private UI ui = new UI();
    private DBUser dbUser = new DBUser();

    public AccountHandler() {

    }

    public void mainMenu() {
        List<String> mainMenu = new ArrayList<>();
        mainMenu.add("Create a user");
        mainMenu.add("Login");
        int input = ui.displayMenu(mainMenu);
        //int input = Integer.parseInt(ui.getInput("Type number:"));

        boolean inputValidator = true;
        while (inputValidator) {

            if (input == 1) {
                createAccount();
                inputValidator = false;
            } else if (input == 2) {
                loginForm();
                inputValidator = false;
            }
        }
    }

    public void loginForm() {
        email = ui.getInput("Enter your email: ");
        password = ui.getInput("Enter your password: ");
        if(loginValidator(email, password)){
            ui.displayMessage("Account with email " + email + " is now logged in.");
        }else{
            List<String> options = new ArrayList<>();
            options.add("Try again");
            options.add("Create account");
            options.add("Type Q to quit the program");

            ui.displayMessage("The email and/or password you entered is wrong.");

            int option = ui.displayMenu(options);

            switch (option) {
                case 1:
                    loginForm();
                    break;
                case 2:
                    createAccount();
                    break;
                case 3:
                    System.exit(0);
            }

        }
    }


    public boolean loginValidator(String email, String password) {
        accounts = dbUser.readUserData(); //Lasse
        for (Account account : accounts) {
            if (account.getEmail().equalsIgnoreCase(email) && account.getPassword().equals(password)) {
                onlineAccount = new Account(email,password); //Lasse
                return true;
            }
        }
        return false;
    }

    public void createAccount() {
        boolean isValidEmail = false;
        while (!isValidEmail) {
            String inputEmail = ui.getInput("Enter your email address. It must end with .dk or .com: ");

            Set<Account> setOfAccounts = dbUser.readUserData();
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
        dbUser.saveUser(email, password);
        ui.displayMessage("Congratulation! Your account has been registered successfully.");
        loginValidator(email, password); //Lasse
    }
    //Lasse
    public Account getOnlineAccount() {
        return
                onlineAccount;
    }
    //Lasse
    public void setOnlineAccount(Account onlineAccount) {
        this.onlineAccount = onlineAccount;
    }
}
