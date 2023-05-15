package Utility;

import Mealplan.Ingredient;
import Mealplan.IngredientList;
import Mealplan.Recipe;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DBRecipe implements DBConnector{
    Connection conn = null;
    PreparedStatement stmt = null;
    public void saveRecipe(Recipe recipe){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to account database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            System.out.println("Creating statement...");
            String query = "INSERT INTO recipes VALUES (null,?)"; //null because first column is id.
            stmt = conn.prepareStatement(query);
            stmt.setString(1,recipe.getTitle()); //right  now only save recipe with title
            //stmt.setString(2,recipe.getDescription());
            //stmt.setInt(3,recipe.getPrepTime());
            //stmt.setInt(4,recipe.getCookTime());
            //stmt.setObject(5,recipe.getIngredients());
            //stmt.setObject(6,recipe.getMethod());

            stmt.execute();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    public Set<Recipe> readRecipes(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to account database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            System.out.println("Creating statement...");
            String query = "SELECT * FROM recipes";
            stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            Set<Recipe> setOfRecipes = new HashSet<>();

            while(rs.next()){
                String title = rs.getString("name"); //Maybe change DB column to title?
                int cookTime = rs.getInt("minutes"); //change column to match Recipe class data
                String ingredientsStr = rs.getString("ingredients"); //needs to be split up and added as IngredientList
                String[] ingredientsArr = ingredientsStr.replaceAll(" ", "").split(",");
                List<String> ingredientList = new ArrayList<>();
                for(int i = 0; i < ingredientsArr.length; i++){
                    ingredientList.add(ingredientsArr[i]);
                }
                String stepsStr = rs.getString("steps"); //needs to be split up and added as List
                String[] stepsArr = stepsStr.replaceAll(" ","").split(",");
                List<String> listOfSteps = new ArrayList<>();
                for(int i = 0; i < stepsArr.length; i++){
                    listOfSteps.add(stepsArr[i]);
                }
                String description = rs.getString("description");

                setOfRecipes.add(new Recipe(title, description, cookTime, ingredientList, listOfSteps));
            }
            rs.close();
            stmt.close();
            conn.close();
            return setOfRecipes;
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return null;
    }
}
