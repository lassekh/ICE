package Utility;

import User.Account;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class DBUser extends DBConnector {

    public void saveUser(String email, String password) {


        try {
            //STEP 3: Execute a query
            System.out.println("Creating statement...");

            //stmt = conn.createStatement();
            String query = "INSERT INTO accounts VALUES (null,?,?)";
            stmt = getConnection().prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password);

            //STEP 4: insert data to database from result set
            stmt.execute();

            //STEP 5: Clean-up environment
            stmt.close();
            getConnection().close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (getConnection() != null) getConnection().close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    public Set<Account> readUserData() {
        try {
            //STEP 3: Execute a query
            System.out.println("Creating statement...");
            String sql = "SELECT * FROM accounts";
            stmt = getConnection().prepareStatement(sql);

            ResultSet rs = stmt.executeQuery(sql);

            //STEP 4: Extract data from result set
            Set<Account> setOfAcounts = new HashSet<>();

            while (rs.next()) {
                //Retrieve by column name

                String email = rs.getString("email");
                String password = rs.getString("password");

                setOfAcounts.add(new Account(email, password));

            }
            //STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            getConnection().close();
            return setOfAcounts;
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (getConnection() != null) getConnection().close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return null;
    }
}
