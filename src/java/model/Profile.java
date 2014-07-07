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
  @NamedQuery(name = "Profile.getAll", query = "SELECT e FROM Profile e")})
public class Profile implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private int USERID;
  @Column
  private String USERNAME;
  @Column
  private String PASSWORD;
  @Column
  private java.sql.Date DATECREATED;
  @Column
  private java.sql.Date LASTLOGIN;
    // avatar blob

  public Profile() {

  }

  public Profile(String username, String password) {
    // Auto-increment password somehow?
    this.USERNAME = username;
    this.PASSWORD = password;

    Date utilDate = new Date();
    this.DATECREATED = new java.sql.Date(utilDate.getTime());
    this.LASTLOGIN = new java.sql.Date(utilDate.getTime());
  }

  public int getUSERID() {
    return USERID;
  }

  public void setUSERID(int USERID) {
    this.USERID = USERID;
  }

  public String getUSERNAME() {
    return USERNAME;
  }

  public void setUSERNAME(String USERNAME) {
    this.USERNAME = USERNAME;
  }

  public String getPASSWORD() {
    return PASSWORD;
  }

  public void setPASSWORD(String PASSWORD) {
    this.PASSWORD = PASSWORD;
  }

  public java.sql.Date getDATECREATED() {
    return this.DATECREATED;
  }

  public void setDATECREATED(java.sql.Date date) {
    this.DATECREATED = date;
  }

  public java.sql.Date getLASTLOGIN() {
    return LASTLOGIN;
  }

  public void setLASTLOGIN(java.sql.Date LASTLOGIN) {
    this.LASTLOGIN = LASTLOGIN;
  }

}
