package com.bionic.edu.socialapp.entity;

public class Message {
}


/*
CREATE TABLE tblMessage (
  id BIGINT NOT NULL AUTO_INCREMENT,
  sendTime BIGINT NOT NULL,
  content VARCHAR (256),
  authorId BIGINT NOT NULL ,
  conversationID BIGINT NOT NULL,
  state BIGINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (id)

) ENGINE=InnDB DEFAULT CHARSET=utf8;
*/