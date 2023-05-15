package Mealplan;

import java.util.List;

public class MealPlan {

    List<DailyMealPlan> myMealPlan;

    public MealPlan(List<DailyMealPlan> myMealPlan){
        this.myMealPlan = myMealPlan;
    }

    String chooseData(String dataChosen){
        return dataChosen;
    }

    Recipe chooseRecipe(String recipeName){
        return null;
    }

    void addDailyMealPlan(String data, Recipe meal){

    }

    void deleteDailyMealPlan(String data){

    }
}
