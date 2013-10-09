package com.bionic.edu.socialapp.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * User: alex
 * Date: 10/3/13
 * Time: 8:32 PM
 */
public class Config {

  private static Config instance;
  Properties properties;

  public static Config getInstance(){
    if (instance==null){
      instance = new Config();
    }
    return instance;
  }

  private Config() {
    properties = new Properties();
    try {
      String filePath = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath()
          .replace("/Config.class", "/config.properties");
      properties.load(new FileInputStream(filePath.replace("file:", "")));
//      properties.load(new FileInputStream("config.properties"));
    } catch (IOException e) {
      e.printStackTrace();
      System.err.println("Unable to load config file. Exit.");
      System.exit(42);
    }
  }

  public String getValue(String key){
    return properties.getProperty(key);
  }

  public String getDBDriver(){
    return properties.getProperty(AppConstants.CFG_DB_DRIVER);
  }

  public String getDConnectionString(){
    return properties.getProperty(AppConstants.CFG_DB_CONNECTION);
  }

  public String getDBLogin(){
    return properties.getProperty(AppConstants.CFG_DB_LOGIN);
  }

  public String getDBPassword(){
    return properties.getProperty(AppConstants.CFG_DB_PASSWORD);
  }

}