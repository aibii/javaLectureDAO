package entities;  //where do you want to access entities from? from entities folder

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Connection getDatabaseConnection() throws SQLException {
        String protocol = "jdbc";
        String dbServer = "mysql";
        String host = "localhost";
        String port = "3306";
        String dbName = "world";

        String dbUrl = String.format("%s:%s://%s:%s/%s", protocol, dbServer, host, port, dbName);
        // jdbc:mysql://localhost:3306/world"; -- Connection string
        // jdbc is API
        // localhost is server name
        // 3306 - port number
        System.out.println(dbUrl);

        return DriverManager.getConnection(dbUrl, "root", "");
    }
}
