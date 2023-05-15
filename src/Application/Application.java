package Application;

import Mealplan.DailyMealPlan;
import Mealplan.Recipe;
import User.AccountHandler;
import Utility.UI;

import java.util.ArrayList;
import java.util.List;

public class Application {

    List<String> options = new ArrayList<>();
    private String welcomeMessage = "Welcome!";
    UI ui = new UI();
    private AccountHandler ah = new AccountHandler(); //Lasse

    public Application() {
        startMenu(); //Lasse
        mainMenu();
    }
    //Lasse
    public void startMenu(){
        ah.loginOrCreateUser();
    }

    public void mainMenu() {
        List<String> options = new ArrayList<>();
        options.add("Show meal plan");
        options.add("create meal plan");
        ui.displayMessage(welcomeMessage);
        int option = ui.displayMenu(options);
        if (option == 1) {
            showMealPlan();
        } else if (option == 2) {
            createMealPlan();
        }

    }
    //Lasse
    public void showMealPlan() {
        try {
            if (ah.getOnlineAccount().getMyMealplan() != null) {
                ui.displayMessage("Your meal plan: " + ah.getOnlineAccount().getMyMealplan());
            }
        }catch(NullPointerException e){
            String input = ui.getInput("You don't have a meal plan. Do you want to create one? Y/N");
            if(input.equalsIgnoreCase("y")){
                createMealPlan();
            }else{
                mainMenu();
            }
        }
    }

    public void createMealPlan() {
        String date = ui.getInput("Enter the date please");
        String recipe = ui.getInput("Whats the name of the recipe?");

        Recipe recipe1 = new Recipe(recipe);
        DailyMealPlan dailyMealPlan = new DailyMealPlan(date, recipe1);
    }
}
