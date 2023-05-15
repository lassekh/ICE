package Application;

import Mealplan.DailyMealPlan;
import Mealplan.Recipe;
import Utility.UI;

import java.util.ArrayList;
import java.util.List;

public class Application {

    List<String> options = new ArrayList<>();
    private String welcomeMessage = "Welcome!";
    UI ui = new UI();

    public Application() {
        menu();
    }


    public void menu() {
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

    public void showMealPlan() {

        System.out.println("showMealPlan method: Finish the method please");
    }

    public void createMealPlan() {
        String date = ui.getInput("Enter the date please");
        String recipe = ui.getInput("Whats the name of the recipe?");

        Recipe recipe1 = new Recipe(recipe);
        DailyMealPlan dailyMealPlan = new DailyMealPlan(date, recipe1);
    }
}
