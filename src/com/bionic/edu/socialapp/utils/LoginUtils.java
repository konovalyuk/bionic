package com.bionic.edu.socialapp.utils;

import com.bionic.edu.socialapp.dao.DAOUser;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * User: alex
 * Date: 10/4/13
 * Time: 11:39 PM
 */
public class LoginUtils {

  private static Map<String, String> tokens = new HashMap<>();

  public static boolean login(String login, String password, String authToken) throws UnsupportedEncodingException {
    // todo
    if (isTokenValidForLogin(authToken, login)){
      return true;
    }
    if (DAOUser.getInstance().login(login, password)){
      tokens.remove(login);
      tokens.put(login, encodeString(login + System.currentTimeMillis()));
      return true;
    }
    return false;
  }

  public static boolean isTokenValidForLogin(String token, String login){
    return token!=null && !token.isEmpty() && tokens.containsValue(token) && token.equals(tokens.get(login));
  }

  // todo add later
  private static String encodeString(String string) throws UnsupportedEncodingException {
    BASE64Encoder encoder = new BASE64Encoder();
    return encoder.encode(string.getBytes("UTF-8" ));
  }

}
