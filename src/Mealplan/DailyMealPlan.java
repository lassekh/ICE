package Mealplan;

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

    public String getDate() {
        return date;
    }

    public String getDay() {
        return day;
    }

    public Recipe getDinner() {
        return dinner;
    }

    @Override
    public String toString() {
        return getDate() + " (" + getDay() + ")" + "\n" + getDinner();
    }

}
