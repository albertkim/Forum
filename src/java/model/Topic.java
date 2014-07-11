package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Topic implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private int TOPICID;
  @Column
  private int USERID;
  @Column
  private int CATEGORYID;
  @Column
  private String CONTENT;
  @Column
  private java.sql.Date DATECREATED;

  public Topic() {

  }

  public Topic(int userId, int categoryId, String content) {
    this.USERID = userId;
    this.CATEGORYID = categoryId;
    this.CONTENT = content;
    Date utilDate = new Date();
    this.DATECREATED = new java.sql.Date(utilDate.getTime());
  }

  public int getTOPICID() {
    return TOPICID;
  }

  public void setTOPICID(int TOPICID) {
    this.TOPICID = TOPICID;
  }

  public int getCATEGORYID() {
    return CATEGORYID;
  }

  public void setCATEGORYID(int CATEGORYID) {
    this.CATEGORYID = CATEGORYID;
  }

  public int getUSERID() {
    return USERID;
  }

  public void setUSERID(int USERID) {
    this.USERID = USERID;
  }

  public String getCONTENT() {
    return CONTENT;
  }

  public void setCONTENT(String CONTENT) {
    this.CONTENT = CONTENT;
  }

  public java.sql.Date getDATECREATED() {
    return DATECREATED;
  }

  public void setDATECREATED(java.sql.Date DATECREATED) {
    this.DATECREATED = DATECREATED;
  }

}
