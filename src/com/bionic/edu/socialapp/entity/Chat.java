package com.bionic.edu.socialapp.entity;

public class Chat {

  private Long id;
  private Long chatId;
  private Long userId;

  public Chat () {
  }

  public Chat (Long id, Long chatId, Long userId) {
    this.id = id;
    this.chatId = chatId;
    this.userId = userId;
  }

  public Long getId () {
    return id;
  }

  public void setId (Long id) {
    this.id = id;
  }

  public Long getChatId () {
    return chatId;
  }

  public void setChatId (Long chatId) {
    this.chatId = chatId;
  }

  public Long getUserId () {
    return userId;
  }

  public void setUserId (Long userId) {
    this.userId = userId;
  }

}