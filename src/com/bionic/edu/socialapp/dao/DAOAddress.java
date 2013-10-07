package com.bionic.edu.socialapp.dao;

/**
 * User: Alexander Kilinskiy
 * Date: 10/7/13 4:57 PM
 */
public class DAOAddress {

  private static DAOAddress instance;

  private DAOAddress(){}

  public static DAOAddress getInstance(){
    if (instance==null){
      instance = new DAOAddress();
    }
    return instance;
  }


}