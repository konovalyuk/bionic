package com.bionic.edu.socialapp.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: alex
 * Date: 10/3/13
 * Time: 8:38 PM
 */
public interface Command {

  public void execute(HttpServletRequest request, HttpServletResponse response);

}
