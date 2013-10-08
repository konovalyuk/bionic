package test;

import com.bionic.edu.socialapp.dao.DAOUser;
import com.bionic.edu.socialapp.utils.LoginUtils;

import java.io.UnsupportedEncodingException;

/**
 * User: alex
 * Date: 10/5/13
 * Time: 10:11 AM
 */
public class TestConnection {

  public static void main(String[] args) throws UnsupportedEncodingException {
//    System.out.println(DAOUser.getInstance().exist("admin"));
//    System.out.println(LoginUtils.encodeString("password"));
    System.out.println(DAOUser.getInstance().exist("admin"));
  }

}
