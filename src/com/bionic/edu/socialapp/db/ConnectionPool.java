package com.bionic.edu.socialapp.db;

import com.bionic.edu.socialapp.utils.Config;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * User: Alexander Kilinskiy
 * Date: 10/15/13 12:37 PM
 */
public class ConnectionPool {

  private static ConnectionPool instance = null;
  private static final String TOMCAT_JNDI_NAME="java:comp/env";
  private DataSource pool;

  public ConnectionPool() {
    initPool();
  }

  public static synchronized ConnectionPool getInstance() {
    if (instance == null) {
      instance = new ConnectionPool();
    }
    return instance;
  }

  private void initPool(){
    try {
      Context initContext = new InitialContext();
      Context envContext = (Context) initContext.lookup(TOMCAT_JNDI_NAME);
      pool = (DataSource)envContext.lookup("source");
    } catch (NamingException e){
      e.printStackTrace();
    }
  }

  public synchronized Connection getConnection() throws SQLException{
    return pool.getConnection();
  }

  public void closeConnection(Connection connection){
    try {
      if(connection != null){
        connection.close();
      }
    } catch(SQLException e){
      e.printStackTrace();
    }
  }

}