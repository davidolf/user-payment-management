INSERT INTO user (id,name,password,level) VALUES (1, 'admin', '$2a$10$PMmUH.HxC8jFdOSU7XrBJuEpb6UPD69T6jj1ZqrxLbSoV/8C9E0lK', 'ADMIN');
INSERT INTO user (id,name,password,level) VALUES (2, 'User1', '$2a$10$EYUcDVZOB/ith4gycyL8Eu3zILdiab96OvwM.OlQMLD58PpK6ovvO','USER');
INSERT INTO user (id,name,password,level) VALUES (3, 'User2', '$2a$10$EYUcDVZOB/ith4gycyL8Eu3zILdiab96OvwM.OlQMLD58PpK6ovvO','USER');
INSERT INTO creditcard (id,userid,number,name,month,year) VALUES (1,2,'4111111111111111','Peter Smith','05','19');
INSERT INTO creditcard (id,userid,number,name,month,year) VALUES (2,3,'4111111111111112','John Foe','05','19');
INSERT INTO creditcard (id,userid,number,name,month,year) VALUES (3,3,'4111111111111113','John Foe','07','22');
INSERT INTO creditcard (id,userid,number,name,month,year) VALUES (4,3,'4111111111111114','John Foe','04','22');