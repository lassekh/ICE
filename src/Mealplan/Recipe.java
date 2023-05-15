package Mealplan;

import java.util.List;

public class Recipe {
    private String title;
    private String description;
    private int prepTime;
    private int cookTime;
    private String ingredients; //change back to type IngredientList at some point
    private String steps;

    public Recipe(String title, String description, int cookTime, String ingredients, String steps) {
        //This constructor only uses strings right now, but should take an instance of IngredientList
        //and a String List of steps.
        this.title = title;
        this.description = description;
        this.cookTime = cookTime;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public Recipe(String title, String description, int prepTime, int cookTime){
        this.title = title;
        this.description = description;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
    }

    public Recipe(String title){

    }
    public void addIngredients(){

    }

    public void addSteps(){

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public int getCookTime() {
        return cookTime;
    }

    public IngredientList getIngredients() {
        return ingredients;
    }

    public List<String> getMethod() {
        return method;
    }
}
