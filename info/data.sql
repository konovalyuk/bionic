-- add admin
INSERT INTO tblUser (lgn, passwd, firstName, lastName, phoneNumber, addressId, userRole, userState)
  VALUES ("admin", "password", "Ivan", "Ivanov", "00380123456789", null, 1, 1);
-- add e-address
UPDATE tblUser SET email = 'admin@example.com' WHERE id=1;
-- add more users
INSERT INTO tblUser (lgn, passwd, firstName, lastName, phoneNumber, addressId, userRole, userState, sex, email)
  VALUES ("user1", "password", "Petr", "Petrov", "00380123456776", null, 0, 1, 1, 'user1@example.com');
INSERT INTO tblUser (lgn, passwd, firstName, lastName, phoneNumber, addressId, userRole, userState, sex, email)
  VALUES ("user2", "password", "Natalia", "Mmm", "00380623456776", null, 0, 1, 0, 'user2@example.com');

