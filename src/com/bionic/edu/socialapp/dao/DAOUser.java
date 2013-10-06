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

  public boolean login(String login, String password){
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

  public void insert(User user ) {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  public void update(User user) {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  public User getUserById(Long id){
    Connection connection = null;
    Statement statement = null;
    try {
      connection = DBConnector.getConnection();
      statement = connection.createStatement();
      StringBuilder queryBuilder = new StringBuilder();
      queryBuilder.append("SELECT * FROM tblUser where id=").append(id).append(";");
      ResultSet resultSet = statement.executeQuery(queryBuilder.toString());
      return getUserFromResultSet(resultSet);
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

  public String getUserFullNameByLogin(String login){
    Connection connection = null;
    Statement statement = null;
    try {
      connection = DBConnector.getConnection();
      statement = connection.createStatement();
      StringBuilder queryBuilder = new StringBuilder();
      queryBuilder.append("SELECT CONCAT(firstName, ' ',lastName) FROM tblUser where lgn='").append(login).append("';");
      ResultSet resultSet = statement.executeQuery(queryBuilder.toString());
      return resultSet.next() ? resultSet.getString(1) : "Unnamed user";
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

  /**
   * Returns User from ResultSet
   * @param resultSet should contain all fields from tblUser
   * @return User, initialized with all fields
   * @throws SQLException
   */
  public static User getUserFromResultSet(ResultSet resultSet) throws SQLException {
    User user = new User();
    user.setId(resultSet.getLong(1));
    user.setLgn(resultSet.getString(2));
    user.setPasswd(resultSet.getString(3));
    user.setFirstName(resultSet.getString(4));
    user.setLastName(resultSet.getString(5));
    user.setPhoneNumber(resultSet.getString(6));
    user.setAddressId(resultSet.getLong(7));
    user.setUserRole(User.UserRole.getByOrdinal(resultSet.getInt(8)));
    user.setUserState(User.UserState.getByOrdinal(resultSet.getInt(9)));
    user.setSex(User.UserSex.getByOrdinal(resultSet.getInt(10)));
    return user;
  }

}