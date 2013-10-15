package com.bionic.edu.socialapp.utils.tags;

import com.bionic.edu.socialapp.entity.User;
import com.bionic.edu.socialapp.utils.HttpUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * User: alex
 * Date: 10/12/13
 * Time: 10:40 AM
 */
public class HeaderTag extends TagSupport {

  @Override
  public int doStartTag() throws JspException {
    try {
      User user = HttpUtils.getUserFromSession((HttpServletRequest)pageContext.getRequest());
      pageContext.getOut().write("<form action=\"/app\" method=\"POST\">" +
                                 "<div style='display: inline-block; height : 30px; width:80%;'>" +
                                 "<a href='/'><img alt='Home' src='/img/icon.png' height=\"30\" width=\"30\"/></a></div>" +
                                 "<div style=\"display: inline-block; height : 30px; width:10%\"> " + getWelcomeString(user) + "</div>" +
                                 "<div style=\"display: inline-block; height : 30px; width:10%\">" + getUserBasedHtml(user) + "</div>" +
                                 "<hr></form>");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return super.doStartTag();
  }

  private String getUserBasedHtml(User user){
    return  (user != null) ? ("<input type=\"hidden\" name=\"cmd\" value=\"logout\"/>\n" +"<input type=\"submit\" value=\"Logout\"/>\n")
                           : "";
  }

  private String getWelcomeString(User user){
    if (user == null) {
      return "";
    }
    return "Welcome, " + user.getFirstName() + " " + user.getLastName();
  }
}
