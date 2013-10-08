package com.bionic.edu.socialapp.db;

import com.bionic.edu.socialapp.utils.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * User: alex
 * Date: 10/3/13
 * Time: 7:26 PM
 */
public class DBConnector {

  private static DBConnector instance;

  private DBConnector(){}

  public static DBConnector getInstance(){
    if (instance==null){
      instance = new DBConnector();
    }
    return instance;
  }

  public Connection getConnection() throws ClassNotFoundException, SQLException {
    Config cfg = Config.getInstance();
    Class.forName(cfg.getDBDriver());
    return DriverManager.getConnection(cfg.getDConnectionString(), cfg.getDBLogin(), cfg.getDBPassword());
  }

  public void execute(String query){
    Connection connection = null;
    Statement statement = null;
    try {
      connection = getConnection();
      statement = connection.createStatement();
      statement.executeQuery(query);
    } catch (SQLException | ClassNotFoundException e) {
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
      if (connection != null){
        try {
          connection.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }

}