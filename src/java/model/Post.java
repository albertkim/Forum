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

@Entity
@Table
@NamedQueries({
  @NamedQuery(name = "Post.getAll", query = "SELECT e FROM Post e")})
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

  public Post() {

  }

  public Post(int userId, String content, int parentId, int topicId) {
    this.USERID = userId;
    this.CONTENT = content;
    this.PARENTID = parentId;
    this.TOPICID = topicId;
    Date utilDate = new Date();
    this.DATECREATED = new java.sql.Date(utilDate.getTime());
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

}
