package Application;

import Mealplan.MealPlanHandler;
import User.AccountHandler;
import Utility.UI;

import java.util.ArrayList;
import java.util.List;

public class Application {

    List<String> options = new ArrayList<>();
    private String welcomeMessage = "Welcome!";
    UI ui = new UI();
    private AccountHandler ah = new AccountHandler(); //Lasse
    private MealPlanHandler mealPlanHandler = new MealPlanHandler();

    public Application() {
        startMenu(); //Lasse
        menu();
    }

    //Lasse
    public void startMenu() {
        ah.mainMenu();
    }

    public void menu() {
        List<String> options = new ArrayList<>();
        options.add("Show meal plan");
        options.add("create meal plan");
        options.add("Close program");
        ui.displayMessage(welcomeMessage);
        int option = ui.displayMenu(options);
        if (option == 1) {
            showMealPlan();
        } else if (option == 2) {
            mealPlanHandler.createMealPlan();
            menu();
        } else if (option == 3) {
            System.exit(0);
        }

    }

    //Lasse
    public void showMealPlan() {
        if (ah.getOnlineAccount().getMyMealplan() != null) {
            ui.displayMessage("Your meal plan: " + ah.getOnlineAccount().getMyMealplan());
        } else {
            String input = ui.getInput("You don't have a meal plan. Do you want to create one? Y/N");
            if (input.equalsIgnoreCase("y")) {
                mealPlanHandler.createMealPlan();
                menu();
            } else {
                menu();
            }
        }
    }

}
