package com.bionic.edu.socialapp.utils.tags;

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
      pageContext.getOut().write("<form action=\"/app\" method=\"POST\">\n" +
          "    <div style=\"text-align: right;\">\n" +
          "        <input type=\"hidden\" name=\"cmd\" value=\"logout\"/>\n" +
          "        <input type=\"submit\" value=\"Logout\"/>\n" +
          "    </div>\n" +
          "</form>");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return super.doStartTag();
  }
}
