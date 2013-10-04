package com.bionic.edu.socialapp.dao;

import com.bionic.edu.socialapp.db.DBConnector;
import com.bionic.edu.socialapp.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: alex
 * Date: 10/3/13
 * Time: 9:00 PM
 */
public class DAOUser {

  private static DAOUser instance;

  private DAOUser(){

  }

  public static DAOUser getInstance(){
    if (instance==null){
      instance = new DAOUser();
    }
    return instance;
  }

  public User getUser(String login, String password) throws SQLException, ClassNotFoundException {
    User user = null;
    ResultSet resultSet = DBConnector.getConnection().createStatement()
        .executeQuery("SELECT * FROM tblUser where lgn='" + login + "' AND passwd='" + password + "';");


    return user;
  }

}
