package com.bionic.edu.socialapp.commands;

import javax.servlet.http.HttpServletRequest;

/**
 * User: alex
 * Date: 10/3/13
 * Time: 8:45 PM
 */
public class CommandFactory {

  private static final String COMMAND_PARAM = "cmd";

  private static CommandFactory instance;

  private CommandFactory(){
  }

  public static CommandFactory getInstance(){
    if (instance==null){
      instance = new CommandFactory();
    }
    return instance;
  }

  public Command getCommand(HttpServletRequest request){
    if (request!=null) {
      String command = request.getParameter(COMMAND_PARAM);
      if (command==null){
        throw new IllegalArgumentException("Empty command");
      }
      command = command.toLowerCase();
      switch (command) {
        case "login" :
          return new LoginCommand();
        case "account":
          return new MyAccountCommand();
        default:
          return new LoginCommand();
      }
    }
    throw new IllegalArgumentException("Bad request");
  }

}
