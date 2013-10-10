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
      connection = DBConnector.getInstance().getConnection();
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

  public User getByLogin(String login){
    Connection connection = null;
    Statement statement = null;
    try {
      connection = DBConnector.getInstance().getConnection();
      statement = connection.createStatement();
      StringBuilder queryBuilder = new StringBuilder();
      queryBuilder.append("SELECT * FROM tblUser where lgn='").append(login).append("';");
      ResultSet resultSet = statement.executeQuery(queryBuilder.toString());
      if (resultSet.next()){
        return getUserFromResultSet(resultSet);
      } else {
        return null;
      }

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
    StringBuilder queryBuilder = new StringBuilder();
    queryBuilder.append("DELETE FROM tblUser where id=").append(id).append(";");
    DBConnector.getInstance().execute(queryBuilder.toString());
  }

  public boolean login(String login, String password){
    Connection connection = null;
    Statement statement = null;
    try {
      connection = DBConnector.getInstance().getConnection();
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
    StringBuilder builder = new StringBuilder();
    builder.append("INSERT INTO tblUser ")
        .append("(lgn, passwd, firstName, lastName, phoneNumber, addressId, userRole, userState, sex, email) VALUES (")
        .append("'").append(user.getLgn()).append("', ")
        .append("'").append(user.getPasswd()).append("', ")
        .append("'").append(user.getFirstName()).append("', ")
        .append("'").append(user.getLastName()).append("', ")
        .append("'").append(user.getPhoneNumber()).append("', ")
        .append(user.getAddressId()).append(", ")
        .append(user.getUserRole().ordinal()).append(", ")
        .append(user.getUserState().ordinal()).append(", ")
        .append(user.getSex().ordinal()).append(", ")
        .append("'").append(user.getEmail()).append("'); ");
    DBConnector.getInstance().insert(builder.toString());
  }

  public void update(User user) {
    StringBuilder builder = new StringBuilder();
    builder.append("UPDATE tblUser SET ")
        .append("lgn = '").append(user.getLgn()).append("', ")
        .append("passwd = '").append(user.getPasswd()).append("', ")
        .append("firstName = '").append(user.getFirstName()).append("', ")
        .append("lastName = '").append(user.getLastName()).append("', ")
        .append("phoneNumber = '").append(user.getPhoneNumber()).append("', ")
        .append("addressId = ").append(user.getAddressId()).append(", ")
        .append("userRole = ").append(user.getUserRole().ordinal()).append(", ")
        .append("userState = ").append(user.getUserState().ordinal()).append(", ")
        .append("sex = ").append(user.getSex())
        .append("email = ").append(user.getEmail())
        .append(" WHERE id=").append(user.getId()).append(";");
    DBConnector.getInstance().execute(builder.toString());
  }

  public User getUserById(Long id){
    Connection connection = null;
    Statement statement = null;
    try {
      connection = DBConnector.getInstance().getConnection();
      statement = connection.createStatement();
      StringBuilder queryBuilder = new StringBuilder();
      queryBuilder.append("SELECT * FROM tblUser where id=").append(id).append(";");
      ResultSet resultSet = statement.executeQuery(queryBuilder.toString());
      if (resultSet.next()){
        return getUserFromResultSet(resultSet);
      } else {
        return null;
      }
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
      connection = DBConnector.getInstance().getConnection();
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

  public void enableDisableUser(Long userId, boolean enable){
    StringBuilder queryBuilder = new StringBuilder();
    queryBuilder.append("UPDATE tblUser SET userState=")
        .append(enable ? User.UserState.ACTIVE : User.UserState.DISABLED)
        .append(" where id=").append(userId).append(";");
    DBConnector.getInstance().execute(queryBuilder.toString());
  }

  public List<User> findByNameOrLastName(String searchPhrase, Long currentUserId){
    Connection connection = null;
    Statement statement = null;
    try {
      connection = DBConnector.getInstance().getConnection();
      statement = connection.createStatement();
      StringBuilder queryBuilder = new StringBuilder();
      queryBuilder.append("SELECT DISTINCT * FROM tblUser WHERE (firstName LIKE '%")
          .append(searchPhrase).append("%' OR lastName LIKE '%").append(searchPhrase).append("%') AND id <>")
          .append(currentUserId).append(";");
      ResultSet resultSet = statement.executeQuery(queryBuilder.toString());
      List<User> matched = new ArrayList<>();
      while (resultSet.next()){
        matched.add(DAOUser.getUserFromResultSet(resultSet));
      }
      return matched;
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

  public void updateUser(User user){
    Connection connection = null;
    Statement statement = null;
    try {
      connection = DBConnector.getInstance().getConnection();
      statement = connection.createStatement();
      StringBuilder queryBuilder = new StringBuilder();
      queryBuilder.append("UPDATE tblUser SET ")
          .append("firstName='").append(user.getFirstName()).append("' ")
          .append("lastName='").append(user.getLastName()).append("' ")
          .append("phoneNumber='").append(user.getPhoneNumber()).append("' ")
          .append("sex=").append(user.getSex()).append(" ")
          .append("email='").append(user.getEmail()).append("' ")
          .append(" WHERE id=").append(user.getId());
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
    user.setEmail(resultSet.getString(11));
    return user;
  }

}