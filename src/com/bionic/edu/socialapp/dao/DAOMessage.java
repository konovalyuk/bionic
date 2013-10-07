package com.bionic.edu.socialapp.dao;

/**
 * User: Alexander Kilinskiy
 * Date: 10/7/13 4:44 PM
 */
public class DAOMessage {

  private static DAOMessage instance;

  private DAOMessage(){}

  public static DAOMessage getInstance(){
    if (instance==null){
      instance = new DAOMessage();
    }
    return instance;
  }
}
