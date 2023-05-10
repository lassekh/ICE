package User;
import java.util.Scanner;

public class User extends HouseHold{
    //Mail instance variabel
    private String mail;
    //Password instance variabel
    private String password;
    //Scanner class to get information from the user
    private Scanner scanner = new Scanner(System.in);
    public User(){
        setMail();
        setPassword();
    }

    //Method to set the mail
    private void setMail(){
        boolean inputValidator = true;
        System.out.println("What's your e-mail?");
        System.out.println("(Your e-mail must either end with .dk or .com)");
        while(inputValidator){
            String input = scanner.nextLine();
            if (input.length() > 5 && input.contains("@") && (input.contains(".com")) || input.contains(".dk")){
                this.mail = input;
                inputValidator = false;
            }
            else {
                System.out.println("Not correct! Try again");
            }
        }
    }

    private void setPassword(){
        boolean inputValidator = true;
        System.out.println("Which passord would you like to create?");
        System.out.println("Must be at least 5 long");
        while(inputValidator){
            String input = scanner.nextLine();
            if (input.length() >= 5){
                this.password = input;
                inputValidator = false;
            }
            else {
                System.out.println("Not correct! Try again");
            }
        }
    }

    //Method to get the mail of the instance
    public String getMail() {
        return mail;
    }

    //Method to get the password of the instance
    public String getPassword() {
        return password;
    }
}
