package Application;

import Mealplan.MealPlanHandler;
import Mealplan.Recipe;
import Utility.DBRecipe;
import Utility.UI;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Application {
    private UI ui = new UI();
    private MealPlanHandler mealPlanHandler = new MealPlanHandler();
    private DBRecipe dbRecipe = new DBRecipe();
    private Scanner scanner = new Scanner(System.in);

    public Application() {
        startMenu();
        menu();
    }

    public void startMenu() {
        ui.displayMessage("\nWelcome to MealPlanner by LAHY\n");
        mealPlanHandler.accountHandler.mainMenu();
    }

    public void menu() {
        ui.displayMessage("Welcome!");
        Set<Recipe> listOfRecipe = new HashSet<>();

        boolean isTrue = true;
        while (isTrue) {

            ui.displayMessage("1) Show available recipes");
            ui.displayMessage("2) Show meal plan");
            ui.displayMessage("3) create meal plan");
            ui.displayMessage("4) Close program");

            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    listOfRecipe = dbRecipe.readRecipes();
                    for (Recipe recipe : listOfRecipe) {
                        System.out.println(recipe);
                    }
                    break;
                case 2:
                    mealPlanHandler.showMealPlan();
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
}