package User;
import Utility.DBUser;
import Utility.UI;
import java.util.*;
public class AccountHandler {
    private Set<Account> accounts = new HashSet<>();
    private String email;
    private String password;
    private Account onlineAccount;
    private UI ui = new UI();
    private DBUser dbUser = new DBUser();
    public AccountHandler() {
    }
    public void mainMenu() {
        List<String> mainMenu = new ArrayList<>();
        mainMenu.add("1) Create a user");
        mainMenu.add("2) Login");
        int menuChoice = ui.displayMenu(mainMenu);
        boolean inputValidator = true;
        while (inputValidator) {
            if (menuChoice == 1) {
                createAccount();
                inputValidator = false;
            } else if (menuChoice == 2) {
                loginForm();
                inputValidator = false;
            }
        }
    }

    public void loginForm() {
        email = ui.getInput("Enter your email: ");
        password = ui.getInput("Enter your password: ");
        if(loginValidator(email, password)){
            ui.displayMessage("Account with email: " + email + " is now logged in.");
        }else{
            List<String> options = new ArrayList<>();
            options.add("1) Try again");
            options.add("2) Create account");
            options.add("3) Type Q to quit the program");

            ui.displayMessage("The email and/or password you entered is wrong.");

            int optionChoice = ui.displayMenu(options);

            switch (optionChoice) {
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
        accounts = dbUser.readUserData();
        for (Account account : accounts) {
            if (account.getEmail().equalsIgnoreCase(email) && account.getPassword().equals(password)) {
                onlineAccount = new Account(email,password);
                return true;
            }
        }
        return false;
    }

    public void createAccount() {
        boolean isValidEmail = false;
        while (!isValidEmail) {
            String inputEmail = ui.getInput("Enter your email address. It must end with .dk or .com: ");
            if(emailValidator(inputEmail)){
                email = inputEmail;
                isValidEmail = true;
            } else {
                System.out.println("Your input is invalid. Please try again.");
            }
        }
        boolean isValidPassword = false;
        while (!isValidPassword) {
            String inputPassword = ui.getInput("Enter a password. It must contain at least 5 characters: ");
            if (passwordValidator(inputPassword)) {
                password = inputPassword;
                isValidPassword = true;
            } else {
                System.out.println("Not correct! Try again");
            }
        }
        dbUser.saveUser(email, password);
        ui.displayMessage("Congratulation! Your account has been registered successfully.");
        loginValidator(email, password);
    }
    public boolean checkIfEmailExists(String email){
        accounts = dbUser.readUserData();
        for (Account account : accounts) {
            if (account.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }
    public boolean emailValidator(String email){
        if (email.contains("@") && (email.endsWith(".com") || email.endsWith(".dk"))) {
            if(checkIfEmailExists(email)) {
                return false;
            }
            return true;
        }
        return false;
    }
    public boolean passwordValidator(String password){
        if (password.length() >= 5){
            return true;
        }else{
            return false;
        }
    }
    public Account getOnlineAccount() {
        return onlineAccount;
    }
    //Lasse
    public void setOnlineAccount(Account onlineAccount) {
        this.onlineAccount = onlineAccount;
    }
}
