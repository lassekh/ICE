package Mealplan;

import java.time.LocalDate;

public class DailyMealPlan {
    private String date;
    private Recipe dinner;

    public DailyMealPlan(LocalDate date, Recipe meal) {
        this.date = String.valueOf(date);
        dinner = meal;
    }

    public void changeDate(String newDate) {

    }

}
