CREATE TABLE PROFILE(
  USERID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  USERNAME VARCHAR(256) NOT NULL,
  PASSWORD VARCHAR(1000),
  DATECREATED DATE NOT NULL,
  LASTLOGIN DATE NOT NULL,
  AVATAR BLOB,
);