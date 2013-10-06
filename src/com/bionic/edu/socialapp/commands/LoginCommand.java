package com.bionic.edu.socialapp.commands;

import com.bionic.edu.socialapp.dao.DAOUser;
import com.bionic.edu.socialapp.utils.AppConstants;
import com.bionic.edu.socialapp.utils.LoginUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

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
    String authToken = request.getParameter(AppConstants.REQUEST_PASSWORD);
    String result = "/login.jsp";
    try {
      if (LoginUtils.login(login, password, authToken)){
        request.setAttribute("loggedUser", DAOUser.getInstance().getUserFullNameByLogin(login));
        result = "/my-account.jsp";
      } else {
        request.setAttribute("invalidLogin", true);
      }
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return  result;
  }

}