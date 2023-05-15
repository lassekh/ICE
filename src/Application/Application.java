package Application;

import Mealplan.DailyMealPlan;
import Mealplan.Recipe;
import Utility.UI;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;

public class Application {

    List<String> options = new ArrayList<>();
    private String welcomeMessage = "Welcome!";
    UI ui = new UI();

    public Application() {
        mainMenu();
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

    public void showMealPlan() {
        System.out.println("showMealPlan method: Finish the method please");
    }

    public void createMealPlan() {
        int year = Integer.parseInt(ui.getInput("Which year do you want to start on? in numbers"));
        int month = Integer.parseInt(ui.getInput("Which month do you want to start on? in numbers"));
        int day = Integer.parseInt(ui.getInput("Which day do you wan to start on?"));

        LocalDate selectedDate = LocalDate.of(year, month, day);

        ui.displayMessage("Time to add the recipe for The following day: "+selectedDate);


        String title = (ui.getInput("Whats the name of the recipe?"));
        String description = (ui.getInput("Can you in few words describe what the is?"));
        int prepTime = Integer.parseInt(ui.getInput("Whats the preparing time for?"+title));
        int cookTime = Integer.parseInt(ui.getInput("Whats the cooking time for?"+title));

        DailyMealPlan dailyMealPlan = new DailyMealPlan(selectedDate, new Recipe(title,description,prepTime,cookTime));

        System.out.println("Done!");

    }
}
