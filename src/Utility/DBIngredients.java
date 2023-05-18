package Utility;

import Mealplan.Ingredient;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class DBIngredients extends DBConnector {

    public Set<Ingredient> readIngredients() {
        try {
            System.out.println("Creating statement...");

            String query = "SELECT * FROM ingredients";
            stmt = getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            Set<Ingredient> setOfIngredients = new HashSet<>();

            while (rs.next()) {
                //String title // Mangler tabel navene for ingredients, som den skal læse fra csv filen.
                setOfIngredients.add(new Ingredient()); // Mangler tabel navene for ingredients.
            }
            rs.close();
            stmt.close();
            getConnection().close();
            return setOfIngredients;
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (getConnection() != null)
                    getConnection().close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return null;
    }

}