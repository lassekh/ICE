package User;


import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import Mealplan.MealPlan;
import Mealplan.Recipe;


public class Account {
    private String email;
    private String password;
    private List<User> users;
    private MealPlan myMealplan;

    public Account(String email, String password){
        this.email = email;
        this.password = password;
        this.users = new LinkedList<User>();
    }

    public String getEmail(){
        return email;

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
        users.remove(name);
    }
    //Lasse
    public MealPlan getMyMealplan() {

        return myMealplan;
    }

    @Override
    public String toString(){
        return "email is " + getEmail() + ", Password is: " + getPassword();
    }
}
