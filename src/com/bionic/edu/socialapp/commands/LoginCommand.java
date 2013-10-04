package com.bionic.edu.socialapp.commands;

import com.bionic.edu.socialapp.utils.AppConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: alex
 * Date: 10/3/13
 * Time: 8:41 PM
 */
public class LoginCommand implements Command {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) {
    String login = request.getParameter(AppConstants.REQUEST_LOGIN);
    String password = request.getParameter(AppConstants.REQUEST_PASSWORD);


  }

}
