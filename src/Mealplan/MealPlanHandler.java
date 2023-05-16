package Mealplan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import Utility.DBRecipe;
import Utility.UI;

public class MealPlanHandler {
    private UI ui = new UI();
    private DBRecipe dbRecipe = new DBRecipe();
    private MealPlan myMealPlan = new MealPlan();
    public void mealPlanOptions(){
        List<String> options = new ArrayList<>();
        options.add("Show a list of recipes");
        options.add("Create your own recipe");
        ui.displayMenu(options);
        int input = Integer.parseInt(ui.getInput("Choose an option 1 or 2"));
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

    public void chooseRecipeFromDB(){
        Set<Recipe> recipesFromDB = dbRecipe.readRecipes();
        for(Recipe r : recipesFromDB) {
            ui.displayMessage(r.getTitle());
        }
        int recipeChoice = Integer.parseInt(ui.getInput("Which recipe would you like to choose?"));
        for(Recipe r : recipesFromDB) {
            if(r.getId() == recipeChoice) {
                myMealPlan.addDailyMealPlan(r);
                ui.displayMessage(r.getTitle() + " added to your meal plan.");
            }
        }
    }
}
