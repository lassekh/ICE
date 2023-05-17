package Application;

import Mealplan.MealPlanHandler;
import Mealplan.Recipe;
import User.AccountHandler;
import Utility.DBRecipe;
import Utility.UI;

import java.util.*;

public class Application {

    List<String> options = new ArrayList<>();
    private String welcomeMessage = "Welcome!";
    UI ui = new UI();
    //private AccountHandler accountHandler = new AccountHandler(); //Lasse
    private MealPlanHandler mealPlanHandler = new MealPlanHandler();
    private DBRecipe dbRecipe = new DBRecipe();
    private Scanner scanner = new Scanner(System.in);

    public Application() {
        startMenu(); //Lasse
        menu();
    }

    //Lasse
    public void startMenu() {
        mealPlanHandler.accountHandler.mainMenu();
    }

    public void menu() {
        ui.displayMessage(welcomeMessage);

        Set<Recipe> listOfRecipe = new HashSet<>();

        boolean isTrue = true;
        while(isTrue){

            /*List<String> options = new ArrayList<>();
            options.add(" Show available recipes");
            options.add(" Show meal plan");
            options.add(" create meal plan");
            options.add(" Show meal plan");
            options.add(" Show meal plan");
            options.add(" Show meal plan");
            options.add(" Show meal plan");
            options.add(" Show meal plan");
            options.add(" Show meal plan");
            options.add(" Show meal plan");


            options.add(" Close program");
            options.add(" Show meal plan");

            int option = ui.displayMenu(options);*/



            ui.displayMessage("1) Show available recipes");
            ui.displayMessage("2) Show meal plan");
            ui.displayMessage("3) create meal plan");
            ui.displayMessage("4) Close program");

            int option = Integer.parseInt(scanner.nextLine());


            switch(option){
                case 1:
                    listOfRecipe = dbRecipe.readRecipes();
                    for (Recipe recipe: listOfRecipe){
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

// Hent alle opskrifter
// Tilknyt Mealplan til Account
// Skal Account have flere MealPlans?
// Hvis I selv har svært ved at finde rundt i koden, så skal I nok overveje at lave flere undermetoder ;-)