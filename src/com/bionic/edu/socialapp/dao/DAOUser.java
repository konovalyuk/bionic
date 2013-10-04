package com.bionic.edu.socialapp.dao;

import com.bionic.edu.socialapp.db.DBConnector;
import com.bionic.edu.socialapp.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * User: alex
 * Date: 10/3/13
 * Time: 9:00 PM
 */
public class DAOUser{

  private static DAOUser instance;

  private DAOUser(){

  }

  public static DAOUser getInstance(){
    if (instance==null){
      instance = new DAOUser();
    }
    return instance;
  }

  public boolean exist(String login) {
    Connection connection = null;
    Statement statement = null;
    try {
      connection = DBConnector.getConnection();
      statement = connection.createStatement();
      StringBuilder queryBuilder = new StringBuilder();
      queryBuilder.append("SELECT 1 FROM tblUser where lgn='").append(login).append("';");
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

  public void delete(Long id) {
    Connection connection = null;
    Statement statement = null;
    try {
      connection = DBConnector.getConnection();
      statement = connection.createStatement();
      StringBuilder queryBuilder = new StringBuilder();
      queryBuilder.append("DELETE FROM tblUser where id=").append(id).append(";");
      statement.executeQuery(queryBuilder.toString());
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

  public void insert(User user ) {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  public void update(User user) {
    //To change body of implemented methods use File | Settings | File Templates.
  }

}
