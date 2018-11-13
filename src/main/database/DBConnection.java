package main.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;

    public static Connection getConnection(){

        try{

            return DriverManager.getConnection("jdbc:sqlite:src/main/mydatabase.db");

        }catch (SQLException exception){

            exception.printStackTrace();

            return null;
        }

    }
}
