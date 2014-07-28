CREATE TABLE CATEGORY(
  CATEGORYID SERIAL NOT NULL,
  NAME VARCHAR(256) NOT NULL,
  TIMECREATED TIMESTAMP,
  PRIMARY KEY (CATEGORYID)
);

INSERT INTO CATEGORY VALUES (DEFAULT, 'Debate', NULL);
INSERT INTO CATEGORY VALUES (DEFAULT, 'Finance', NULL);
INSERT INTO CATEGORY VALUES (DEFAULT, 'Technology', NULL);
INSERT INTO CATEGORY VALUES (DEFAULT, 'Off-topic', NULL);