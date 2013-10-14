package com.bionic.edu.socialapp.controller.filter;

import com.bionic.edu.socialapp.entity.User;
import com.bionic.edu.socialapp.utils.AppConstants;
import com.bionic.edu.socialapp.utils.UrlHelper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * User: alex
 * Date: 10/12/13
 * Time: 10:03 am
 */
public class AuthFilter implements Filter {

  // commands which are allowed without auth
  private static final List<String> ALLOWED_COMMANDS = Arrays.asList("login", "registration", "logout");

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpSession  session = ((HttpServletRequest)request).getSession();
    User user = (User) session.getAttribute(AppConstants.SESSION_USER);
    if (needsAuth(request.getParameter(AppConstants.REQUEST_COMMAND))){
      if (user == null){
        request.getRequestDispatcher(UrlHelper.URL_LOGIN).forward(request, response);
      }
    }
    chain.doFilter(request, response);
  }

  private boolean needsAuth(String command) {
    return command != null && !command.isEmpty() && !ALLOWED_COMMANDS.contains(command);
  }

  @Override
  public void destroy() {
  }
}
