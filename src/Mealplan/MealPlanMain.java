package Mealplan;

import java.util.ArrayList;
import java.util.List;

public class MealPlanMain {

    public static void main(String[] args) {

        Recipe recipe1 = new Recipe("test");

        List<DailyMealPlan> listOfDailyMealPlan = new ArrayList<>();

        DailyMealPlan dailyMealPlan = new DailyMealPlan("test",recipe1);

        MealPlan mealPlan = new MealPlan(listOfDailyMealPlan);


    }
}
