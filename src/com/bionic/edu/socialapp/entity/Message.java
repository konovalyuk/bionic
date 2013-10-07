package com.bionic.edu.socialapp.entity;

public class Message {

  private Long id;
  private Long sendTime;
  private String content;
  private Long authorId;
  private Long conversationId;
  private MessageState state;

  public Message() {
  }

  public Message(Long id, Long sendTime, String content, Long authorId, Long conversationId, MessageState state) {
    this.id = id;
    this.sendTime = sendTime;
    this.content = content;
    this.authorId = authorId;
    this.conversationId = conversationId;
    this.state = state;
  }

  public enum MessageState{
    NOT_SENT, SENT, SEEN
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getSendTime() {
    return sendTime;
  }

  public void setSendTime(Long sendTime) {
    this.sendTime = sendTime;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Long getAuthorId() {
    return authorId;
  }

  public void setAuthorId(Long authorId) {
    this.authorId = authorId;
  }

  public Long getConversationId() {
    return conversationId;
  }

  public void setConversationId(Long conversationId) {
    this.conversationId = conversationId;
  }

  public MessageState getState() {
    return state;
  }

  public void setState(MessageState state) {
    this.state = state;
  }

}