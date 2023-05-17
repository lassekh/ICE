package Mealplan;

import User.AccountHandler;
import Utility.DBRecipe;
import Utility.UI;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class MealPlanHandler {
    private UI ui = new UI();
    private DBRecipe dbRecipe = new DBRecipe();
    private MealPlan myMealPlan = new MealPlan();
    public AccountHandler accountHandler = new AccountHandler();

    public void createMealPlan() {

        List<String> options1 = new ArrayList<>();
        options1.add("Select a date you wish to start from");
        options1.add("Use the current date");
        int input1 = ui.displayMenu(options1);

        LocalDate selectedDate = null;
        DayOfWeek dayOfWeek;
        String weekday;
        int year = 0;
        int month = 0;
        int day = 0;
        boolean selectDay = false;

        if (input1 == 1) {
            year = Integer.parseInt(ui.getInput("Which year do you want to start on? (in numbers)"));
            month = Integer.parseInt(ui.getInput("Which month do you want to start on? (in numbers)"));
            day = Integer.parseInt(ui.getInput("Which day do you wan to start on? (in numbers)"));
            selectedDate = LocalDate.of(year, month, day);
            selectDay = true;

        } else if (input1 == 2) {
            selectedDate = LocalDate.now();
            selectDay = false;
        }

        int counter = 0;
        dayOfWeek = selectedDate.getDayOfWeek();
        weekday = dayOfWeek.toString();

        ui.displayMessage("Time to add the recipe for The following day: " + weekday + " (" + selectedDate + ")");

        List<String> optionsMenu = new ArrayList<>();
        optionsMenu.add("Create your own recipe.");
        optionsMenu.add("See all the available recipes.");

        boolean inputValidator = true;


        while (inputValidator) {
            String inputMenu = String.valueOf(ui.displayMenu(optionsMenu));

            if (inputMenu.equalsIgnoreCase(String.valueOf(1))) {

                String title = (ui.getInput("Whats the name of the recipe?"));
                String description = (ui.getInput("Can you in few words describe what the is?"));
                int prepTime = Integer.parseInt(ui.getInput("Whats the preparing time for " + title + "? (in minutes)"));
                int cookTime = Integer.parseInt(ui.getInput("Whats the cooking time for " +
                        title + "? (in minutes)"));

                Recipe recipe = new Recipe(title, description, prepTime, cookTime);

                DBRecipe dbRecipe = new DBRecipe();
                dbRecipe.saveRecipe(recipe);


                List<String> options = new ArrayList<>();
                options.add("Do you want to create one for the next day?");
                options.add("Do you want to save and go back to main menu?");
                String input = String.valueOf(ui.displayMenu(options));

                if (input.equalsIgnoreCase("1")) {
                    if (selectDay) {
                        counter++;
                        selectedDate = LocalDate.of(year, month, day + counter);
                        dayOfWeek = selectedDate.getDayOfWeek();
                        weekday = dayOfWeek.toString();
                        ui.displayMessage("Time to add the recipe for The following day: " + weekday + " (" + selectedDate + ")");
                        String date = selectedDate.toString();
                        myMealPlan.addDailyMealPlan(date, weekday, recipe);

                    } else {
                        selectedDate = selectedDate.plusDays(1);
                        dayOfWeek = selectedDate.getDayOfWeek();
                        weekday = dayOfWeek.toString();
                        ui.displayMessage("Time to add the recipe for The following day: " + weekday + " (" + selectedDate + ")");
                        String date = selectedDate.toString();
                        myMealPlan.addDailyMealPlan(date, weekday, recipe);

                    }

                } else if (input.equalsIgnoreCase("2")) {
                    ui.displayMessage("Your data has been saved!");
                    inputValidator = false;
                }

            } else if ((inputMenu.equalsIgnoreCase(String.valueOf(2)))) {
                chooseRecipeFromDB(weekday, selectedDate.toString()); //Is toString right?
                List<String> options = new ArrayList<>();
                options.add("Do you want to create one for the next day?");
                options.add("Do you want to save and go back to main menu?");
                String input = String.valueOf(ui.displayMenu(options));

                if (input.equalsIgnoreCase("1")) {
                    if (selectDay) {
                        counter++;
                        selectedDate = LocalDate.of(year, month, day + counter);
                        dayOfWeek = selectedDate.getDayOfWeek();
                        weekday = dayOfWeek.toString();
                        ui.displayMessage("Time to add the recipe for The following day: " + weekday + " (" + selectedDate + ")");
                        String date = selectedDate.toString();
                    } else {
                        selectedDate = selectedDate.plusDays(1);
                        dayOfWeek = selectedDate.getDayOfWeek();
                        weekday = dayOfWeek.toString();
                        ui.displayMessage("Time to add the recipe for The following day: " + weekday + " (" + selectedDate + ")");
                    }

                } else if (input.equalsIgnoreCase("2")) {
                    ui.displayMessage("Your data has been saved!");
                    inputValidator = false;
                }
            }
        }
    }

    public void chooseRecipeFromDB(String day, String date) {
        Set<Recipe> recipesFromDB = dbRecipe.readRecipes();
        for (Recipe r : recipesFromDB) {
            ui.displayMessage(r.getId() + ") " + r.getTitle());

        }
        int recipeChoice = Integer.parseInt(ui.getInput("Which recipe would you like to choose?"));
        for (Recipe r : recipesFromDB) {
            if (r.getId() == recipeChoice) {
                myMealPlan.addDailyMealPlan(date, day, r);
                ui.displayMessage(r.getTitle() + " added to your meal plan.");
            }
        }
    }

    public void showMealPlan() {
        if (myMealPlan.getMyMealPlan().size() == 0 ){
            ui.displayMessage("You do not have recipes in your mealplan");
        } else if (myMealPlan.getMyMealPlan().size() >= 1) {
            ui.displayMessage("Your mealplan:\n"+myMealPlan.getMyMealPlan());
        }
    }
}