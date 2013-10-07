package com.bionic.edu.socialapp.entity;

public class Address {

  private Long id;
  private Long cityId;
  private String street;

  public Address () {
  }

  public Address (Long id, Long cityId, String street) {
    this.id = id;
    this.cityId = cityId;
    this.street = street;
  }

  public Long getId () {
    return id;
  }

  public void setId (Long id) {
    this.id = id;
  }

  public Long getCityId () {
    return cityId;
  }

  public void setCityId (Long cityId) {
    this.cityId = cityId;
  }

  public String getStreet () {
    return street;
  }

  public void setStreet (String street) {
    this.street = street;
  }

}