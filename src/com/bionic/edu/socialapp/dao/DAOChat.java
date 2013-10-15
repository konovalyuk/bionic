package com.bionic.edu.socialapp.dao;

import com.bionic.edu.socialapp.db.ConnectionPool;
import com.bionic.edu.socialapp.db.DBTools;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * User: Alexander Kilinskiy
 * Date: 10/7/13 4:56 PM
 */
public class DAOChat {

  private static DAOChat instance;

  private DAOChat(){}

  public static DAOChat getInstance(){
    if (instance==null){
      instance = new DAOChat();
    }
    return instance;
  }

  public void addUserToChat(Long userId, Long chatId){
    Connection connection = null;
    Statement statement = null;
    ConnectionPool pool = ConnectionPool.getInstance();
    try {
      connection = pool.getConnection();
      statement = connection.createStatement();
      StringBuilder queryBuilder = new StringBuilder();
      queryBuilder.append("INSERT INTO tblChat (chatID, userID) VALUES(").append(chatId).append(",").append(userId)
          .append(");");
      statement.execute(queryBuilder.toString());
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