package com.bionic.edu.socialapp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * User: alex
 * Date: 10/3/13
 * Time: 7:26 PM
 */
public class DBConnector {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
      Class.forName("com.mysql.jdbc.Driver");
      return DriverManager.getConnection("jdbc:mysql://localhost:3306/social_app_lite", "root", "root");
    }

}
