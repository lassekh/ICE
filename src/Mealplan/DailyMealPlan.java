package Mealplan;

import java.time.LocalDate;

public class DailyMealPlan {
    private String date;
    private String day;
    private Recipe dinner;

    public DailyMealPlan(String date, String day, Recipe meal) {
        this.date = date;
        this.day = day;
        dinner = meal;
    }

    public void changeDate(String newDate) {

    }

}
