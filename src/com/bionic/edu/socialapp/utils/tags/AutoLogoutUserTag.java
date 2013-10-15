package com.bionic.edu.socialapp.utils.tags;

import com.bionic.edu.socialapp.entity.User;
import com.bionic.edu.socialapp.utils.AppConstants;
import com.bionic.edu.socialapp.utils.HttpUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * User: Alexander Kilinskiy
 * Date: 10/15/13 1:40 PM
 */
public class AutoLogoutUserTag extends TagSupport {

  @Override
  public int doStartTag() throws JspException {
    pageContext.getSession().removeAttribute(AppConstants.SESSION_USER);
    return super.doStartTag();
  }

}
