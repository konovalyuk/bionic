package com.bionic.edu.socialapp.utils;

import com.bionic.edu.socialapp.db.DBConnector;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * User: alex
 * Date: 10/4/13
 * Time: 11:39 PM
 */
public class LoginUtils {

  public static boolean login(String login, String password){
    // todo
    Connection connection = null;
    Statement statement = null;
    try {
      connection = DBConnector.getConnection();
      statement = connection.createStatement();
      StringBuilder queryBuilder = new StringBuilder();
      queryBuilder
          .append("SELECT 1 FROM tblUser where lgn='").append(login)
          .append("' AND passwd='").append(password).append("';");
      ResultSet resultSet = statement.executeQuery(queryBuilder.toString());
      return resultSet.first();
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

  // todo add later
  private static String encodePassword(String password) throws UnsupportedEncodingException {
    BASE64Encoder encoder = new BASE64Encoder();
    return encoder.encode(password.getBytes("UTF-8" ));
  }

}
