package Mealplan;

import java.util.List;

public class MealPlan {

    List<DailyMealPlan> myMealPlan;
    public MealPlan(){
        //Dummy constructor made by Lasse. Delete at som point.
    }

    public MealPlan(List<DailyMealPlan> myMealPlan){
        this.myMealPlan = myMealPlan;
    }

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

    void deleteDailyMealPlan(String data){


    }
}
