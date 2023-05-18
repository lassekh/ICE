package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public abstract class DBConnector {

    static final String DB_URL = "jdbc:mysql://34.141.56.218/mealplanner";
    static final String USER = "root";
    static final String PASS = "LAHY-Dat23!";
    public PreparedStatement stmt = null;

    public Connection getConnection() {
        try {
            //STEP 1: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            //STEP 2: Open a connection
            System.out.println("Connecting to account database...");
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
