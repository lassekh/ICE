package Mealplan;

import java.util.List;

public class Recipe {
    private String title;
    private String description;
    private int prepTime;
    private int cookTime;
    private IngredientList ingredients;
    List<String> method;

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

    public void addMethod(){

    }


}
