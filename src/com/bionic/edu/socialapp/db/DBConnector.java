package com.bionic.edu.socialapp.db;

import com.bionic.edu.socialapp.utils.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: alex
 * Date: 10/3/13
 * Time: 7:26 PM
 */
public class DBConnector {

  public static Connection getConnection() throws ClassNotFoundException, SQLException {
    Config cfg = Config.getInstance();
    Class.forName(cfg.getDBDriver());
    return DriverManager.getConnection(cfg.getDConnectionString(), cfg.getDBLogin(), cfg.getDBPassword());
  }

}
