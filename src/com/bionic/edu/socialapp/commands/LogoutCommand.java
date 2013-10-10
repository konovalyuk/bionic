package com.bionic.edu.socialapp.commands;

import com.bionic.edu.socialapp.utils.UrlHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: alex
 * Date: 10/10/13
 * Time: 6:53 PM
 */
public class LogoutCommand implements Command {
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    request.getSession().invalidate();
    return UrlHelper.URL_INDEX;
  }
}
