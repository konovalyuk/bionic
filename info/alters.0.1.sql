CREATE DATABASE social_app_lite;

USE social_app_lite;

CREATE TABLE tblUser (
  id BIGINT NOT NULL AUTO_INCREMENT,
  lgn VARCHAR(50) NOT NULL ,
  passwd VARCHAR(256) NOT NULL,
  firstName VARCHAR (50) NOT NULL,
  lastName VARCHAR (50) NOT NULL,
  phoneNumber VARCHAR (18),
  addressId BIGINT,
  userRole BIGINT(1) NOT NULL DEFAULT 0,
  userState BIGINT(1) NOT NULL DEFAULT 0,

  PRIMARY KEY (id),
  UNIQUE KEY (lgn),
  UNIQUE KEY (phoneNumber)

) ENGINE=InnDB DEFAULT CHARSET=utf8;

CREATE TABLE tblFriend (
  id BIGINT NOT NULL AUTO_INCREMENT,
  userID BIGINT NOT NULL,
  friendID BIGINT NOT NULL,

  PRIMARY KEY (id),

  UNIQUE KEY (userID, friendID),

  CONSTRAINT fk_tbluser_user_id FOREIGN KEY (userID) REFERENCES tblUser(id),
  CONSTRAINT fk_tbluser_friend_id FOREIGN KEY (friendID) REFERENCES tblUser(id)

) ENGINE=InnDB DEFAULT CHARSET=utf8;

CREATE TABLE tblMessage (
  id BIGINT NOT NULL AUTO_INCREMENT,
  sendTime BIGINT NOT NULL,
  content VARCHAR (256),
  authorId BIGINT NOT NULL ,
  conversationID BIGINT NOT NULL,
  state BIGINT(1) NOT NULL DEFAULT 0,

  PRIMARY KEY (id)

) ENGINE=InnDB DEFAULT CHARSET=utf8;

CREATE TABLE tblChat (
  id BIGINT NOT NULL AUTO_INCREMENT,
  chatID BIGINT NOT NULL ,
  userID BIGINT NOT NULL,

  PRIMARY KEY (id),

  UNIQUE KEY (chatID, userID),

  CONSTRAINT fk_tblchatuser_user_id FOREIGN KEY (userID) REFERENCES tblUser(id),
  CONSTRAINT fk_tblchatuser_chat_id FOREIGN KEY (chatID) REFERENCES tblChat(id)

) ENGINE=InnDB DEFAULT CHARSET=utf8;

CREATE TABLE tblCountry(
  id BIGINT NOT NULL AUTO_INCREMENT ,
  name VARCHAR (50),

  PRIMARY KEY (id),

  UNIQUE KEY (name)

) ENGINE=InnDB DEFAULT CHARSET=utf8;

CREATE TABLE tblCity (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  countryID BIGINT NOT NULL,
  name VARCHAR (50) NOT NULL,

  PRIMARY KEY (id),

  CONSTRAINT fk_tblcountry_country_id FOREIGN KEY (countryID) REFERENCES tblCountry(id)

) ENGINE=InnDB DEFAULT CHARSET=utf8;

CREATE TABLE tblAddress (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  cityID BIGINT NOT NULL ,
  street VARCHAR (70),

  PRIMARY KEY (id),

  CONSTRAINT fk_tbladdress_city_id FOREIGN KEY (cityID) REFERENCES tblCity(id)

) ENGINE=InnDB DEFAULT CHARSET=utf8;
#  add 'sex' column to tblUser
ALTER TABLE tblUser ADD COLUMN sex BIGINT(1) NOT NULL DEFAULT 1;
#  add 'email' column to tblUser
ALTER TABLE tblUser ADD COLUMN email VARCHAR(50) NOT NULL;
ALTER TABLE tblUser ADD UNIQUE(email);

CREATE TABLE tblFriendRequest (

  id  BIGINT NOT NULL AUTO_INCREMENT,
  fromID BIGINT NOT NULL,
  toID BIGINT NOT NULL,

  PRIMARY KEY (id),

  CONSTRAINT fk_tblFriendRequest_from_id FOREIGN KEY (fromID) REFERENCES tblUser(id),
  CONSTRAINT fk_tblFriendRequest_to_id FOREIGN KEY (toID) REFERENCES tblUser(id)

) ENGINE=InnDB DEFAULT CHARSET=utf8;

CREATE TABLE tblNotification (
  id  BIGINT NOT NULL AUTO_INCREMENT,
  userID BIGINT NOT NULL,
  type BIGINT (1) NOT NULL ,

  PRIMARY KEY (id),

  CONSTRAINT fk_tblNotification_user_id FOREIGN KEY (userID) REFERENCES tblUser(id)

) ENGINE=InnDB DEFAULT CHARSET=utf8;
