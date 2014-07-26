package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="RATING_ASSOC")
public class RatingAssoc implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column int ID;
  
  @Column
  private int POSTID;
  @Column
  private int USERID;
  @Column
  private boolean UPVOTE;

  public RatingAssoc() {

  }

  public RatingAssoc(int userId, int postId, boolean upvote) {
    this.USERID = userId;
    this.POSTID = postId;
    this.UPVOTE = upvote;
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

  public int getID() {
    return ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public boolean isUPVOTE() {
    return UPVOTE;
  }

  public void setUPVOTE(boolean UPVOTE) {
    this.UPVOTE = UPVOTE;
  }

}