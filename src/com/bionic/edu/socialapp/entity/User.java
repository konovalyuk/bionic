package com.bionic.edu.socialapp.entity;

/**
 * User: alex
 * Date: 10/3/13
 * Time: 8:05 PM
 */
public class User {

  private Long id;
  private String lgn;
  private String passwd;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private Long addressId;
  private UserRole userRole;
  private UserState userState;
  private UserSex sex;

  public enum UserRole{
    USER, ADMIN;

    public static UserRole getByOrdinal(int ordinal){
      return UserRole.values()[ordinal];
    }

  }

  public enum UserState{
    ACTIVE, DISABLED;

    public static UserState getByOrdinal(int ordinal){
      return UserState.values()[ordinal];
    }

  }

  public enum UserSex{
    WOMEN, MAN;

    public static UserSex getByOrdinal(int ordinal){
      return UserSex.values()[ordinal];
    }
  }

  public User() {
  }

  public User(Long id,
              String lgn,
              String passwd,
              String firstName,
              String lastName,
              String phoneNumber,
              Long addressId,
              UserRole userRole,
              UserState userState,
              UserSex sex) {
    this.id = id;
    this.lgn = lgn;
    this.passwd = passwd;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.addressId = addressId;
    this.userRole = userRole;
    this.userState = userState;
    this.sex = sex;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLgn() {
    return lgn;
  }

  public void setLgn(String lgn) {
    this.lgn = lgn;
  }

  public String getPasswd() {
    return passwd;
  }

  public void setPasswd(String passwd) {
    this.passwd = passwd;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Long getAddressId() {
    return addressId;
  }

  public void setAddressId(Long addressId) {
    this.addressId = addressId;
  }

  public UserRole getUserRole() {
    return userRole;
  }

  public void setUserRole(UserRole userRole) {
    this.userRole = userRole;
  }

  public UserState getUserState() {
    return userState;
  }

  public void setUserState(UserState userState) {
    this.userState = userState;
  }

  public UserSex getSex() {
    return sex;
  }

  public void setSex(UserSex sex) {
    this.sex = sex;
  }

}