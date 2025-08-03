

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDatabaseConnection {
    public static void main(String[] args) {
     
        String URL = "jdbc:mysql://localhost:3306/hospital_db";
        String USER = "root";  
        String PASSWORD = "";

        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            if (conn != null) {
                System.out.println("Database connection successful!");
                conn.close(); 
            } else {
                System.out.println("Connection failed.");
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        
        System.out.println("Connection test complete.");
    }
}
