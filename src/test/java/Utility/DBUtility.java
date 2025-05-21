package Utility;

import java.sql.*;
import java.util.ArrayList;

public class DBUtility {
    public static Connection connection;
    public static Statement statement;

    public static void DBConnectionOpen(){

        String serverUrl = "jdbc:mysql://demo.mersys.io:33906/sakila";  //port,dbname,mySql
        String username = "student";
        String password = "DEkzTd3#pzPm";

        try{
            connection= DriverManager.getConnection(serverUrl,username,password);
            statement=connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
    public static void DBConnectionClose(){

        try {
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<ArrayList<String>> getListData(String sorgu){
        ArrayList<ArrayList<String>>allData=new ArrayList<>();
        DBConnectionOpen();

        try {
            ResultSet resultSet=statement.executeQuery(sorgu);
            ResultSetMetaData rsmd =resultSet.getMetaData();

            while (resultSet.next()){
                ArrayList<String>satır=new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount() ; i++) {
                    satır.add(resultSet.getString(i));
                }
                allData.add(satır);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        DBConnectionClose();
        return allData;
    }
}
