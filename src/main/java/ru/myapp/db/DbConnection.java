package ru.myapp.db;

import java.sql.*;

public class DbConnection {

    public void getDbConnection() throws SQLException {

        String dbUsers = "postgres";
        String dbPassword = "postgres";
        String connectionUrl = "jdbc:postgresql://localhost:5432/list_users";

        Connection connection = DriverManager.getConnection(connectionUrl, dbUsers, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM list_user");

        while(resultSet.next()){
            System.out.print(resultSet.getString("name") + " =" + resultSet.getString("password"));
        }
    }
}