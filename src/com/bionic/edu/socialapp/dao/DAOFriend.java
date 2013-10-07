package com.bionic.edu.socialapp.dao;

import com.bionic.edu.socialapp.db.DBConnector;
import com.bionic.edu.socialapp.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * User: alex
 * Date: 10/5/13
 * Time: 12:52 PM                                                                 \
 */
public class DAOFriend {

  private static DAOFriend instance;

  private DAOFriend(){}

  public static DAOFriend getInstance(){
    if (instance==null){
      instance = new DAOFriend();
    }
    return instance;
  }

  public List<User> listFriends(Long userId) {
    Connection connection = null;
    Statement statement = null;
    try {
      connection = DBConnector.getConnection();
      statement = connection.createStatement();
      StringBuilder queryBuilder = new StringBuilder();
      queryBuilder.append("SELECT u.* FROM tblFriend f, tblUser u WHERE f.userID=" + userId + " AND u.id=f.friendID;");
      ResultSet resultSet = statement.executeQuery(queryBuilder.toString());
      List<User> friends = new ArrayList<>();
      while (resultSet.next()){
        friends.add(DAOUser.getUserFromResultSet(resultSet));
      }
      return friends;
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

  public void addFriend(Long userId, Long friendId){
    Connection connection = null;
    Statement statement = null;
    try {
      connection = DBConnector.getConnection();
      statement = connection.createStatement();
      StringBuilder queryBuilder = new StringBuilder();
      queryBuilder.append("INSERT INTO tblFriend (userID, friendID) VALUES(").append(userId).append(",").append(friendId).append(");");
      statement.execute(queryBuilder.toString());
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

  public void removeFriend(Long userId, Long friendId){
    Connection connection = null;
    Statement statement = null;
    try {
      connection = DBConnector.getConnection();
      statement = connection.createStatement();
      StringBuilder queryBuilder0 = new StringBuilder();
      StringBuilder queryBuilder1 = new StringBuilder();
      queryBuilder0.append("DELETE FROM tblFriend WHERE userID=").append(userId).append(" AND friendID=").append(friendId).append(";");
      queryBuilder1.append("DELETE FROM tblFriend WHERE userID=").append(friendId).append(" AND friendID=").append(userId).append(";");
      statement.execute(queryBuilder0.toString());
      statement.execute(queryBuilder1.toString());
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
