DROP TABLE TOPIC;
CREATE TABLE TOPIC(
  TOPICID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  CATEGORYID INTEGER NOT NULL,
  CONTENT VARCHAR(5000) NOT NULL,
  USERID INTEGER NOT NULL,
  DATECREATED DATE NOT NULL,
  TIMECREATED TIMESTAMP,
  DATEUPDATED DATE NOT NULL,
  TIMEUPDATED TIMESTAMP,
  CUSTOM VARCHAR(10000),
  PRIMARY KEY (TOPICID)
);