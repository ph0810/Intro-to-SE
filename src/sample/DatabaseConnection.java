package sample;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnection {

    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "demo_db";
        String databaseUser = "root";
        String databasePassword = "P@5sword";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception e) {
//            System.out.println("2");
            e.printStackTrace();
            e.getCause();
        }

        return databaseLink;
    }
}
