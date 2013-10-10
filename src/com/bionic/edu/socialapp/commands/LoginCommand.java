package com.bionic.edu.socialapp.commands;

import com.bionic.edu.socialapp.dao.DAOFriend;
import com.bionic.edu.socialapp.dao.DAOUser;
import com.bionic.edu.socialapp.entity.User;
import com.bionic.edu.socialapp.utils.AppConstants;
import com.bionic.edu.socialapp.utils.LoginUtils;
import com.bionic.edu.socialapp.utils.UrlHelper;

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
    String result = UrlHelper.URL_LOGIN;
    try {
      if (LoginUtils.login(login, password)){
        User user = DAOUser.getInstance().getByLogin(login);
        request.setAttribute("loggedUser", user.getFirstName() + " " + user.getLastName());
        request.setAttribute("user", user);
        request.getSession().setAttribute("user", user);
        request.setAttribute("friends", DAOFriend.getInstance().listFriends(user.getId()));
        result = UrlHelper.URL_MY_ACCOUNT;
      } else {
        request.setAttribute("invalidLogin", true);
        request.setAttribute(AppConstants.REQUEST_LOGIN, login);
      }
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return  result;
  }

}