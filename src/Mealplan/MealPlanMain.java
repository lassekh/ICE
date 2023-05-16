package Mealplan;

import Utility.DBRecipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MealPlanMain {

    public static void main(String[] args) {

        //Recipe recipe1 = new Recipe("test");

        //List<DailyMealPlan> listOfDailyMealPlan = new ArrayList<>();

        //DailyMealPlan dailyMealPlan = new DailyMealPlan("test",recipe1);

        //MealPlan mealPlan = new MealPlan(listOfDailyMealPlan);
        //DBRecipe db = new DBRecipe();
        //Set<Recipe> recipes = db.readRecipes();
        //for(Recipe r : recipes) {
        //    System.out.println(r);
        //}
        MealPlanHandler mph = new MealPlanHandler();
        mph.chooseRecipeFromDB();
        /*DBRecipe db = new DBRecipe();
        Set<Recipe> recipes = db.readRecipes();
        for(Recipe r : recipes) {
            System.out.println(r);
        }*/

        MealPlanHandler mealPlanHandler = new MealPlanHandler();

        mealPlanHandler.createMealPlan();
    }
}
