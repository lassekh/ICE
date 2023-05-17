package User;
import Mealplan.MealPlan;
public class Account {
    private String email;
    private String password;
    private MealPlan myMealplan;

    public Account(String email, String password){
        this.email = email;
        this.password = password;
        myMealplan = new MealPlan();

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
    public MealPlan getMyMealplan() {
        return myMealplan;
    }
    @Override
    public String toString(){
        return "Account email is " + getEmail() + ", Account password is: " + getPassword();
    }
}
