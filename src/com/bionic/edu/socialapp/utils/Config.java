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

  private Config() {
    Properties properties = new Properties();
    try {
      properties.load(new FileInputStream(new File("/config/config.properties")));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
