package com.bionic.edu.socialapp.controller;

import com.bionic.edu.socialapp.commands.Command;
import com.bionic.edu.socialapp.commands.CommandFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: alex
 * Date: 10/3/13
 * Time: 8:53 PM
 */
public class ControllerServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
    Command command = CommandFactory.getInstance().getCommand(request);
    command.execute(request, response);
  }
}
