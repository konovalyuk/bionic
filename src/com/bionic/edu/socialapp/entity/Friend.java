package com.bionic.edu.socialapp.entity;

/**
 * User: alex
 * Date: 10/5/13
 * Time: 12:53 PM
 */
public class Friend {

  private Long id;
  private Long userID;
  private Long friendID;

  public Friend() {
  }

  public Friend(Long id, Long userID, Long friendID) {
    this.id = id;
    this.userID = userID;
    this.friendID = friendID;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserID() {
    return userID;
  }

  public void setUserID(Long userID) {
    this.userID = userID;
  }

  public Long getFriendID() {
    return friendID;
  }

  public void setFriendID(Long friendID) {
    this.friendID = friendID;
  }

}