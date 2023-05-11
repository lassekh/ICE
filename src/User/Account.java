package User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Account {
    private String mail;
    private String password;
    private List<User> users;
    public Account(String mail, String password){
        this.mail = mail;
        this.password = password;
        this.users = new LinkedList<User>();

    }

    public String getMail(){
        return mail;

    }
    public String getPassword(){
        return password;
    }
    public User createUser(String name, int age){
        User user = new User(name, age);
        return user;
    }
    public void deleteUser(String name){
        //this.users er en ArrayList af denne Accounts users
        this.users.remove(name);
    }


}
