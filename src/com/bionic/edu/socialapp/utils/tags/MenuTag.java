package com.bionic.edu.socialapp.utils.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * User: Alexander Kilinskiy
 * Date: 10/15/13 1:59 PM
 */
public class MenuTag extends TagSupport {

  @Override public int doStartTag () throws JspException {
    try {
      pageContext.getOut().write(getMenu());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return super.doStartTag();
  }

  private String getMenu(){
    return getFriendsDiv() + getMessagesDiv() + getNotificationsDiv() + getSearchDiv();
  }

  private String getSearchDiv () {
    return "<div  class='menu' >\n" +
           "      <form name=\"friendSearchForm\" method=\"POST\" action=\"/app\">\n" +
           "        <input type=\"hidden\" name=\"cmd\" value=\"search\"/>\n" +
           "        <input type=\"text\" name=\"friendName\" placeholder=\"- friend name -\"/>\n" +
           "        <input type=\"submit\" value=\"Search for friend\"/>\n" +
           "      </form>\n" +
           "</div>";
  }

  private String getNotificationsDiv () {
    return "<div  class='menu'>\n" +
           "      <form name=\"notificationsForm\" method=\"POST\" action=\"/app\">\n" +
           "        <input type=\"hidden\" name=\"cmd\" value=\"notifications\"/>\n" +
           "        <input type=\"submit\" value=\"Notifications\"/>\n" +
           "      </form>\n" +
           "</div>\n";
  }

  private String getMessagesDiv () {
    return "<div  class='menu'>\n" +
           "      <form name=\"messagesForm\" method=\"POST\" action=\"/app\">\n" +
           "        <input type=\"hidden\" name=\"cmd\" value=\"msg\"/>\n" +
           "        <input type=\"submit\" value=\"Messages\"/>\n" +
           "      </form>\n" +
           "</div>\n";
  }

  private String getFriendsDiv () {
    return "<div class='menu'>\n" +
           "      <form name=\"friendsForm\" method=\"POST\" action=\"/app\">\n" +
           "        <input type=\"hidden\" name=\"cmd\" value=\"friends\"/>\n" +
           "        <input type=\"submit\" value=\"Friends\"/>\n" +
           "      </form>\n" +
           "</div>\n";
  }
}
