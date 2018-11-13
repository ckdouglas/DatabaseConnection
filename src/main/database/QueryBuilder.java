package main.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryBuilder {


    static Connection connection = DBConnection.getConnection();

    static Statement statement = null;

    static String query = "";

    static PreparedStatement preparedStatement = null;


    //select all
     public static  ResultSet selectAll(String table){

         try {

             query = "SELECT * FROM "+ table;

             statement = connection.createStatement();

             return statement.executeQuery(query);

         }catch (SQLException exception){

             exception.printStackTrace();

             return null;
         }
     }

    //select various columns
    public static ResultSet selectColumns(String table, List columns ){

        try {

            String cols = columns.toString().replace("[", "").replace("]", "");

             query = "SELECT " + cols + " FROM " + table;

            System.out.println(query);

             statement = connection.createStatement();

            return statement.executeQuery(query);

        }catch (SQLException exception){

            exception.printStackTrace();

            return null;
        }
    }

    //insertData
     public static void insertData(String table, List columns,List values){




         List columnsPlaceholders = new ArrayList();

         for (int i = 0; i<=columns.size()-1;i++){

             columnsPlaceholders.add("?");

            }
         query = "INSERT INTO "+table+columns.toString().replace("[","( ").replace("]"," )")+"VALUES"+columnsPlaceholders.toString().replace("[","( ").replace("]"," )");

         System.out.println(query);

         System.out.println(values.get(1));


         try {

            preparedStatement = connection.prepareStatement(query);

              for (int i = 1; i<= values.size();i++){
 
                  preparedStatement.setString(i,values.get(i-1).toString());
              }

               preparedStatement.execute();

                preparedStatement.close();


         }catch (SQLException exception){

             exception.printStackTrace();

         }

    }

    //select  1 2 3 4 5 from 8 8 8 8 where 123445 order


}
