package Utility;

import Mealplan.Ingredient;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class DBIngredients implements DBConnector{
    Connection conn = null;
    PreparedStatement stmt = null;
    public Set<Ingredient> readIngredients(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connection to account database...");

            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Creating statement...");

            String query = "SELECT * FROM ingredients";
            stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            Set<Ingredient> setOfIngredients = new HashSet<>();

            while(rs.next()){
                //String title // Mangler tabel navene for ingredients, som den skal læse fra csv filen.
                setOfIngredients.add(new Ingredient()); // Mangler tabel navene for ingredients.
            }
            rs.close();
            stmt.close();
            conn.close();

            return setOfIngredients;
        }catch (SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(stmt != null)
                    stmt.close();
            }catch (SQLException se2){
            }
            try{
                if(conn != null)
                    conn.close();
            }catch (SQLException se){
                se.printStackTrace();
            }
        }
        return null;
    }

}