package com.bionic.edu.socialapp.utils;

import java.util.ResourceBundle;

/**
 * User: alex
 * Date: 10/3/13
 * Time: 8:32 PM
 */
public class Config {

  private static Config instance;
  ResourceBundle properties;

  public static Config getInstance(){
    if (instance==null){
      instance = new Config();
    }
    return instance;
  }

  private Config() {
    try {
      properties = ResourceBundle.getBundle("com.bionic.edu.socialapp.utils.config");
    } catch (Exception e) {
      e.printStackTrace();
      System.err.println("Unable to load config file. Exit.");
      System.exit(42);
    }

  }

  public String getValue(String key){
    return properties.getString(key);
  }

  public String getDBDriver(){
    return properties.getString(AppConstants.CFG_DB_DRIVER);
  }

  public String getDConnectionString(){
    return properties.getString(AppConstants.CFG_DB_CONNECTION);
  }

  public String getDBLogin(){
    return properties.getString(AppConstants.CFG_DB_LOGIN);
  }

  public String getDBPassword(){
    return properties.getString(AppConstants.CFG_DB_PASSWORD);
  }

}