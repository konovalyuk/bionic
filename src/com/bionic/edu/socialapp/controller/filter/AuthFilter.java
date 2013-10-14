package com.bionic.edu.socialapp.controller.filter;

import com.bionic.edu.socialapp.entity.User;
import com.bionic.edu.socialapp.utils.AppConstants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * User: alex
 * Date: 10/12/13
 * Time: 10:03 am
 */
public class AuthFilter implements Filter {


  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpSession  session = ((HttpServletRequest)servletRequest).getSession();
    User user = (User) session.getAttribute(AppConstants.SESSION_USER);
    servletRequest.getParameter("cmd"); // todo
    System.out.println(user);
    filterChain.doFilter(servletRequest, servletResponse);
  }

  @Override
  public void destroy() {
  }
}
