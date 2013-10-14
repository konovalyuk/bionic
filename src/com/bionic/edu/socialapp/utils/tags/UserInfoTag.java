package com.bionic.edu.socialapp.utils.tags;

import com.bionic.edu.socialapp.entity.User;
import com.bionic.edu.socialapp.utils.HttpUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * User: alex
 * Date: 10/12/13
 * Time: 10:26 AM
 */
public class UserInfoTag extends TagSupport {

  @Override
  public int doStartTag() throws JspException {
    User user = HttpUtils.getUserFromSession((HttpServletRequest)pageContext.getRequest());
    if (user != null) {
      String userPresentation = user.getFirstName() + " " + user.getLastName();
      try {
        pageContext.getOut().write(userPresentation);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return super.doStartTag();
  }
}
