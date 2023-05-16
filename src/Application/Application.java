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
        ui.displayMessage(welcomeMessage);

        while(true){
            List<String> options = new ArrayList<>();
            options.add("1) Show available recipes");
            options.add("2) Show meal plan");
            options.add("3) create meal plan");
            options.add("4) Close program");

            int option = ui.displayMenu(options);

            switch(option){
                case 2:
                    showMealPlan();
                    break;
                case 3:
                    mealPlanHandler.createMealPlan();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }
    }

    //Lasse
    // Har for meget ansvar. Viser MealPlan OG kan potentielt håndtere oprettelsen af en
    public void showMealPlan() {
        if (ah.getOnlineAccount().getMyMealplan() != null) {
            ui.displayMessage("Your meal plan: " + ah.getOnlineAccount().getMyMealplan());
        } else {
            String input = ui.getInput("You don't have a meal plan. Do you want to create one? Y/N");
            if (input.equalsIgnoreCase("y")) {
                mealPlanHandler.createMealPlan();
                //menu();
            } else {
                //menu();
            }
        }
    }
}

// Hent alle opskrifter
// Tilknyt Mealplan til Account
// Skal Account have flere MealPlans?
// Hvis I selv har svært ved at finde rundt i koden, så skal I nok overveje at lave flere undermetoder ;-)