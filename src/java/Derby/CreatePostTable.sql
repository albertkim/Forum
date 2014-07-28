CREATE TABLE POST(
  POSTID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  USERID INTEGER NOT NULL REFERENCES PROFILE(USERID),
  CONTENT VARCHAR(5000) NOT NULL,
  PARENTID INTEGER DEFAULT 0,
  TOPICID INTEGER NOT NULL REFERENCES TOPIC(TOPICID),
  DATECREATED DATE NOT NULL,
  TIMECREATED TIMESTAMP,
  UPVOTES INTEGER DEFAULT 0,
  DOWNVOTES INTEGER DEFAULT 0,
  CUSTOM VARCHAR(10000),
  DELETED BOOLEAN DEFAULT FALSE,
  PRIMARY KEY (POSTID)
);