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
 * Time: 12:52 PM
 */
public class DAOFriend {

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

  public void addFriend(){
   // todo
  }

  public void removeFriend(){
    // todo
  }

}
