CREATE TABLE ACCOUNT (
  USERID NUMBER PRIMARY KEY NOT NULL,
  USERNAME VARCHAR(256) NOT NULL,
  PASSWORD VARCHAR(1000) NOT NULL,
  DATECREATED DATE NOT NULL,
  LASTLOGIN DATE NOT NULL,
  AVATAR BLOB
);

DROP SEQUENCE USERID_SEQ;
CREATE SEQUENCE USERID_SEQ
  START WITH 1 
  INCREMENT BY 1 
  NOMAXVALUE;

CREATE OR REPLACE TRIGGER USERID_TRIGGER
  BEFORE INSERT ON ACCOUNT
  FOR EACH ROW
   BEGIN :new.USERID := USERID_SEQ.nextval;
END;