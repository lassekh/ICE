package Mealplan;

import java.util.ArrayList;
import java.util.List;

public class MealPlan {

    private List<DailyMealPlan> myMealPlan = new ArrayList<>();


    String chooseData(String dataChosen){
        return dataChosen;
    }

    Recipe chooseRecipe(String recipeName){
        return null;
    }

    public void addDailyMealPlan(String date, String day, Recipe meal){
        DailyMealPlan dailyMealPlan = new DailyMealPlan(date, day, meal);
        myMealPlan.add(dailyMealPlan);

    }
}
