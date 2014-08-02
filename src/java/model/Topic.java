package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

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
  private String URL;
  @Column
  private java.sql.Date DATECREATED;
  @Column
  private java.sql.Timestamp TIMECREATED;
  @Column
  private java.sql.Date DATEUPDATED;
  @Column
  private java.sql.Timestamp TIMEUPDATED;
  
  @Transient
  private int REPLIES;
  @Transient
  private String CATEGORYNAME;

  public Topic() {

  }

  public Topic(int userId, int categoryId, String content, String url) {
    this.USERID = userId;
    this.CATEGORYID = categoryId;
    this.CONTENT = content;
    Date utilDate = new Date();
    this.DATECREATED = new java.sql.Date(utilDate.getTime());
    this.TIMECREATED = new java.sql.Timestamp(utilDate.getTime());
    this.DATEUPDATED = this.DATECREATED;
    this.TIMEUPDATED = new java.sql.Timestamp(utilDate.getTime());
    this.URL = url;
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

  public String getURL() {
    return URL;
  }

  public void setURL(String URL) {
    this.URL = URL;
  }

  public java.sql.Date getDATECREATED() {
    return DATECREATED;
  }

  public void setDATECREATED(java.sql.Date DATECREATED) {
    this.DATECREATED = DATECREATED;
  }
  
  public java.sql.Date getDATEUPDATED() {
    return this.DATEUPDATED;
  }
  
  // when called, will update the DATEUPDATED field with current date
  public void setDATEUPDATED() {
    Date utilDate = new Date();
    this.DATEUPDATED = new java.sql.Date(utilDate.getTime());
  }
  
  public java.sql.Timestamp getTIMECREATED(){
    return this.TIMECREATED;
  }
  
  public java.sql.Timestamp getTIMEUPDATED(){
    return this.TIMEUPDATED;
  }

  public int getREPLIES() {
    return REPLIES;
  }

  public void setREPLIES(int REPLIES) {
    this.REPLIES = REPLIES;
  }

  public String getCATEGORYNAME() {
    return CATEGORYNAME;
  }

  public void setCATEGORYNAME(String CATEGORYNAME) {
    this.CATEGORYNAME = CATEGORYNAME;
  }

}
