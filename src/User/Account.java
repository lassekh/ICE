package User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Account {
    private String mail;
    private String password;
    public Account(String mail, String password){
        this.mail = mail;
        this.password = password;
    }

    public String getMail(){
        return mail;

    }
    public String getPassword(){
        return password;
    }


}
