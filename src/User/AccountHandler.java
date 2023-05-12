package User;

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

    public AccountHandler() {

    }

    public void loginOrCreateUser() {

        List<String> listOfMenuOptions = new ArrayList<>();
        listOfMenuOptions.add("Create a user");
        listOfMenuOptions.add("Login");

        ui.displayMenu(listOfMenuOptions);

        scanner = new Scanner(System.in);

        boolean inputValidator = true;
        while (inputValidator) {
            try {
                int input = scanner.nextInt();
                if (input == 1) {
                    createAccount();
                    inputValidator = false;
                } else if (input == 2) {
                    ui.loginMenu();
                    inputValidator = false;
                } else {
                    System.out.println("Invalid input. Please enter either 1 or 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("You did not type a number. Please try again:");
                scanner.nextLine(); // Clear the invalid input from the scanner
            }
        }
    }


    public String createMail() {
        Scanner scanner = new Scanner(System.in);
        boolean isValidEmail = false;
        String inputEmail;
        scanner = new Scanner(System.in);

        System.out.print("Enter your email address. It must end with .dk or .com: ");

        while (!isValidEmail) {
            inputEmail = scanner.nextLine();
            if (inputEmail.contains("@") && (inputEmail.endsWith(".com") || inputEmail.endsWith(".dk"))) {
                email = inputEmail;
                isValidEmail = true;
                return email;
            } else {
                System.out.println("Your inout is invalid. Please try again.");
            }
        }
        return null;
    }

    public String createPassword() {
        boolean inputValidPassword = false;
        scanner = new Scanner(System.in);
        String inputPassword;

        System.out.println("Enter a password. It must contain at least 5 characters: ");

        while (!inputValidPassword) {
            inputPassword = scanner.nextLine();
            if (inputPassword.length() >= 5) {
                password = inputPassword;
                return password;
            } else {
                System.out.println("Not correct! Try again");
            }
        }
        return null;
    }

    public boolean login(String email, String password) {
        for (Account account: accounts){
            if(account.getEmail().equalsIgnoreCase(email) && account.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public void createAccount() {
        account = new Account(createMail(), createPassword());
        accounts.add(account);

        System.out.println(account);

    }
}
