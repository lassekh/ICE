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
            LocalDate selectedDate = getStartDate();
            int counter = 0;

            while (true) {
                DayOfWeek dayOfWeek = selectedDate.getDayOfWeek();
                String weekday = dayOfWeek.toString();

                ui.displayMessage("Time to add the recipe for the following day: " + weekday + " (" + selectedDate + ")");

                List<String> optionsMenu = new ArrayList<>();
                optionsMenu.add("Create your own recipe.");
                optionsMenu.add("See all the available recipes.");

                String inputMenu = String.valueOf(ui.displayMenu(optionsMenu));

                if (inputMenu.equalsIgnoreCase("1")) {
                    Recipe recipe = createRecipe();
                    saveRecipeAndAddToMealPlan(recipe, selectedDate);

                    if (shouldCreateForNextDay()) {
                        selectedDate = getNextDay(selectedDate, counter);
                        counter++;
                    } else {
                        ui.displayMessage("Your data has been saved!");
                        break;
                    }
                } else if (inputMenu.equalsIgnoreCase("2")) {
                    chooseRecipeFromDB(weekday, selectedDate.toString());

                    if (shouldCreateForNextDay()) {
                        selectedDate = getNextDay(selectedDate, counter);
                        counter++;
                    } else {
                        ui.displayMessage("Your data has been saved!");
                        break;
                    }
                }
            }
        }

        private LocalDate getStartDate() {
            List<String> options = new ArrayList<>();
            options.add("Select a date you wish to start from");
            options.add("Use the current date");
            int input = ui.displayMenu(options);

            if (input == 1) {
                int year = Integer.parseInt(ui.getInput("Which year do you want to start on? (in numbers)"));
                int month = Integer.parseInt(ui.getInput("Which month do you want to start on? (in numbers)"));
                int day = Integer.parseInt(ui.getInput("Which day do you want to start on? (in numbers)"));
                return LocalDate.of(year, month, day);
            } else if (input == 2) {
                return LocalDate.now();
            }
            return null; // Return a default value or handle the case when input is neither 1 nor 2
        }

        private Recipe createRecipe() {
            String title = ui.getInput("What's the name of the recipe?");
            String description = ui.getInput("Can you describe the recipe in a few words?");
            int prepTime = Integer.parseInt(ui.getInput("What's the preparing time for " + title + "? (in minutes)"));
            int cookTime = Integer.parseInt(ui.getInput("What's the cooking time for " + title + "? (in minutes)"));

            Recipe recipe = new Recipe(title, description, prepTime, cookTime);
            dbRecipe.saveRecipe(recipe);

            return recipe;
        }

        private void saveRecipeAndAddToMealPlan(Recipe recipe, LocalDate selectedDate) {
            DayOfWeek dayOfWeek = selectedDate.getDayOfWeek();
            String weekday = dayOfWeek.toString();
            String date = selectedDate.toString();
            myMealPlan.addDailyMealPlan(date, weekday, recipe);
        }

        private boolean shouldCreateForNextDay() {
            List<String> options = new ArrayList<>();
            options.add("Do you want to create one for the next day?");
            options.add("Do you want to save and go back to the main menu?");
            String input = String.valueOf(ui.displayMenu(options));

            return input.equalsIgnoreCase("1");
        }

        private LocalDate getNextDay(LocalDate currentDate, int counter) {
            return currentDate.plusDays(counter + 1);
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
            if (myMealPlan.getMyMealPlan().isEmpty()) {
                ui.displayMessage("You do not have recipes in your meal plan.");
            } else {
                ui.displayMessage("Your meal plan:\n" + myMealPlan.getMyMealPlan());
            }
        }
}