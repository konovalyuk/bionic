package com.bionic.edu.socialapp.commands;

import com.bionic.edu.socialapp.entity.User;
import com.bionic.edu.socialapp.utils.HttpUtils;
import com.bionic.edu.socialapp.utils.UrlHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: alex
 * Date: 10/3/13
 * Time: 8:52 PM
 */
public class MyAccountCommand implements Command {
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    User user = HttpUtils.getUserFromSession(request);
    if (user == null) {
      return UrlHelper.URL_LOGIN;
    }

    return null;
  }

}
