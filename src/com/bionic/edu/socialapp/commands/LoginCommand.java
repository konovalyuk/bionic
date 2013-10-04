package com.bionic.edu.socialapp.commands;

import com.bionic.edu.socialapp.dao.DAOUser;
import com.bionic.edu.socialapp.utils.AppConstants;
import com.bionic.edu.socialapp.utils.LoginUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: alex
 * Date: 10/3/13
 * Time: 8:41 PM
 */
public class LoginCommand implements Command {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    String login = request.getParameter(AppConstants.REQUEST_LOGIN);
    String password = request.getParameter(AppConstants.REQUEST_PASSWORD);
    return LoginUtils.login(login, password) ? "some success string" : "login fail";
  }

}