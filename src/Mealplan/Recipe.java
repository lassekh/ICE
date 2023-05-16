package Mealplan;

import java.util.List;
import java.util.Objects;

public class Recipe {
    private int id;
    private String title;
    private String description;
    private int prepTime;
    private int cookTime;
    private List<String> ingredients; //change back to type IngredientList at some point
    private List<String> steps;

    public Recipe(int id, String title, String description, int cookTime, List<String> ingredients, List<String> steps) {
        //This constructor only uses strings right now, but should take an instance of IngredientList
        //and a String List of steps.
        this.id = id;
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
        this.title = title;
    }
    public void addIngredients(){

    }

    public void addSteps(){

    }

    public int getId() {
        return id;
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
    @Override
    public String toString(){
        return "Title: " + getTitle();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipe recipe)) return false;
        return id == recipe.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
