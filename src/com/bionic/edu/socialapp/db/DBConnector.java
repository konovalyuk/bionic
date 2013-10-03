package com.bionic.edu.socialapp.db;

import java.sql.DriverManager;

/**
 * User: alex
 * Date: 10/3/13
 * Time: 7:26 PM
 */
public class DBConnector {

    public void getConnection() throws ClassNotFoundException {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbdbd", "mysql", "mysql");
      stm=con.createStatement();
    }

}
