package Mealplan;

import java.util.ArrayList;
import java.util.List;

public class MealPlan {
    private List<DailyMealPlan> myMealPlan = new ArrayList<>();

    public void addDailyMealPlan(String date, String day, Recipe meal) {
        DailyMealPlan dailyMealPlan = new DailyMealPlan(date, day, meal);
        myMealPlan.add(dailyMealPlan);
    }

    public List<DailyMealPlan> getMyMealPlan() {
        return myMealPlan;
    }
}
