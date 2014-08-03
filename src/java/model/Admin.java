package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="administrator")
public class Admin implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private String ADMINID;
  @Column
  private int USERID;
  
  public Admin() {
    
  }

  public Admin(int userId) {
    this.USERID = userId;
  }

  public String getADMINID() {
    return ADMINID;
  }

  public void setADMINID(String ADMINID) {
    this.ADMINID = ADMINID;
  }

  public int getUSERID() {
    return USERID;
  }

  public void setUSERNAME(int userId) {
    this.USERID = userId;
  }

}