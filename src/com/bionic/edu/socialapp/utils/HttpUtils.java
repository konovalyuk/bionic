package com.bionic.edu.socialapp.utils;

import com.bionic.edu.socialapp.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * User: alex
 * Date: 10/10/13
 * Time: 6:57 PM
 */
public class HttpUtils {

  public static User getUserFromSession(HttpServletRequest request){
    HttpSession session = request.getSession(true);
    return (User) session.getAttribute(AppConstants.SESSION_USER);
  }

}
