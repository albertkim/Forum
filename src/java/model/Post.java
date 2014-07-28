package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
@NamedQueries({@NamedQuery(name = "Post.getAll", query = "SELECT e FROM Post e")})
public class Post implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "POSTID", nullable = false)
  private int POSTID;
  @Column
  private int USERID;
  @Column
  private String CONTENT;     // Contents of the post
  @Column
  private int PARENTID;       // To tell whether the post is a response to another post, 0 if main post
  @Column
  private int TOPICID;
  @Column
  private java.sql.Date DATECREATED;
  @Column
  private java.sql.Timestamp TIMECREATED;
  @Column
  private int UPVOTES;
  @Column
  private int DOWNVOTES;
  @Column
  private String CUSTOM;
  @Column
  private boolean DELETED;
  
  @Transient
  private String USERNAME;
  @Transient
  private String PARENTPOST;
  @Transient
  private String PARENTUSERNAME;
  @Transient
  private int REPLIES;

  public Post() {

  }

  public Post(int userId, String content, int parentId, int topicId) {
    this.USERID = userId;
    this.CONTENT = content;
    this.PARENTID = parentId;
    this.TOPICID = topicId;
    Date utilDate = new Date();
    this.DATECREATED = new java.sql.Date(utilDate.getTime());
    Date date = new Date();
    this.TIMECREATED = new java.sql.Timestamp(date.getTime());
  }

  public int getPOSTID() {
    return POSTID;
  }

  public void setPOSTID(int POSTID) {
    this.POSTID = POSTID;
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

  public int getPARENTID() {
    return PARENTID;
  }

  public void setPARENTID(int PARENTID) {
    this.PARENTID = PARENTID;
  }

  public int getTOPICID() {
    return TOPICID;
  }

  public void setTOPICID(int TOPICID) {
    this.TOPICID = TOPICID;
  }
  
  public java.sql.Date getDATECREATED(){
    return this.DATECREATED;
  }
  
  public java.sql.Timestamp getTIMECREATED(){
    return this.TIMECREATED;
  }

  public String getUSERNAME() {
    return USERNAME;
  }

  public void setUSERNAME(String USERNAME) {
    this.USERNAME = USERNAME;
  }

  public String getPARENTPOST() {
    return PARENTPOST;
  }

  public void setPARENTPOST(String PARENTPOST) {
    this.PARENTPOST = PARENTPOST;
  }

  public int getREPLIES() {
    return REPLIES;
  }

  public void setREPLIES(int REPLIES) {
    this.REPLIES = REPLIES;
  }

  public int getUPVOTES() {
    return UPVOTES;
  }

  public void setUPVOTES(int UPVOTES) {
    this.UPVOTES = UPVOTES;
  }

  public int getDOWNVOTES() {
    return DOWNVOTES;
  }

  public void setDOWNVOTES(int DOWNVOTES) {
    this.DOWNVOTES = DOWNVOTES;
  }

  public String getCUSTOM() {
    return CUSTOM;
  }

  public void setCUSTOM(String CUSTOM) {
    this.CUSTOM = CUSTOM;
  }

  public String getPARENTUSERNAME() {
    return PARENTUSERNAME;
  }

  public void setPARENTUSERNAME(String PARENTUSERNAME) {
    this.PARENTUSERNAME = PARENTUSERNAME;
  }

  public boolean isDELETED() {
    return DELETED;
  }

  public void setDELETED(boolean DELETED) {
    this.DELETED = DELETED;
  }

}