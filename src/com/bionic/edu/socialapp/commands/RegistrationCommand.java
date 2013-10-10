package com.bionic.edu.socialapp.commands;

import com.bionic.edu.socialapp.dao.DAOUser;
import com.bionic.edu.socialapp.entity.User;
import com.bionic.edu.socialapp.utils.AppConstants;
import com.bionic.edu.socialapp.utils.UrlHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: alex
 * Date: 10/8/13
 * Time: 9:05 PM
 */
public class RegistrationCommand implements Command {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    String login = request.getParameter(AppConstants.REQUEST_LOGIN);
    String password1 = request.getParameter(AppConstants.REQUEST_PASSWORD1);
    String password2 = request.getParameter(AppConstants.REQUEST_PASSWORD2);
    String email = request.getParameter(AppConstants.REQUEST_EMAIL);
    String phone = request.getParameter(AppConstants.REQUEST_PHONE_NUMBER);
    String firstName = request.getParameter(AppConstants.REQUEST_FIRST_NAME);
    String lastName = request.getParameter(AppConstants.REQUEST_LAST_NAME);
    String sex = request.getParameter(AppConstants.REQUEST_SEX);

    int sexInt = Integer.parseInt(sex);

    User user = new User();
    user.setLgn(login);
    user.setPasswd(password1);
    user.setFirstName(firstName);
    user.setLastName(lastName);
    user.setEmail(email);
    user.setUserState(User.UserState.ACTIVE);
    user.setUserRole(User.UserRole.USER);
    user.setPhoneNumber(phone);
    user.setSex(User.UserSex.getByOrdinal(sexInt));

    try {
      DAOUser.getInstance().insert(user);
    } catch (RuntimeException e){
      e.printStackTrace();

      return UrlHelper.URL_REGISTRATION;
    }
    User registered = DAOUser.getInstance().getByLogin(login);
    request.setAttribute("loggedUser", registered.getFirstName() + " " + registered.getLastName());
    request.getSession().setAttribute("user", registered);
    return UrlHelper.URL_MY_ACCOUNT;
  }

  private boolean isLoginUnique(String login){
    return DAOUser.getInstance().getByLogin(login) == null;
  }

  private boolean isEmailUnique(String email){
    return true;//todo
  }

  private boolean isPhoneUnique(String phone){
    return true; // todo
  }

}