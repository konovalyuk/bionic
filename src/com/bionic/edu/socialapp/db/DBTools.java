package com.bionic.edu.socialapp.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * User: alex
 * Date: 10/3/13
 * Time: 7:26 PM
 */
public class DBTools {

//  public Connection getConnection() throws ClassNotFoundException, SQLException {
//    Config cfg = Config.getInstance();
//    Class.forName(cfg.getDBDriver());
//    return DriverManager.getConnection(cfg.getDConnectionString(), cfg.getDBLogin(), cfg.getDBPassword());
//  }

  public static void execute(String query){
    Connection connection = null;
    Statement statement = null;
    ConnectionPool pool = ConnectionPool.getInstance();
    try {
      connection = pool.getConnection();
      statement = connection.createStatement();
      statement.executeQuery(query);
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
    finally {
      if (statement != null){
        try {
          statement.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      pool.closeConnection(connection);
    }
  }

  public static void insert(String query){
    Connection connection = null;
    Statement statement = null;
    ConnectionPool pool = ConnectionPool.getInstance();
    try {
      connection = pool.getConnection();
      statement = connection.createStatement();
      statement.execute(query);
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
    finally {
      if (statement != null){
        try {
          statement.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      pool.closeConnection(connection);
    }
  }


}