package com.bionic.edu.socialapp.utils.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * User: Alexander Kilinskiy
 * Date: 10/14/13 4:52 PM
 */
public class FooterTag extends TagSupport {

  @Override
  public int doStartTag() throws JspException {
    try {
      pageContext.getOut().write("<div style=\"position:fixed; width:100%; bottom:0px; text-align: right;\">" +
                                 "<hr><h6>Test project from Bionic University (J2EE), social app</h6></div>");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return super.doStartTag();
  }

}
