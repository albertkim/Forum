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
// Imports for password hashing
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;

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
  
  // Password hashing variables
  private static final int ITERATIONS = 1000;
  private static final int KEY_LENGTH = 192; // bits
  private static final String salt = "HERPDERPLOL";

  public Profile() {

  }

  public Profile(String username, String password) throws Exception{
    this.USERNAME = username;
    this.setPASSWORD(password);

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

  public void setPASSWORD(String PASSWORD) throws Exception{
    this.PASSWORD = hashPassword(PASSWORD);
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
  
  public static String hashPassword(String password) throws Exception{
    char[] passwordChars = password.toCharArray();
    byte[] saltBytes = salt.getBytes();

    PBEKeySpec spec = new PBEKeySpec(
        passwordChars,
        saltBytes,
        ITERATIONS,
        KEY_LENGTH
    );
    SecretKeyFactory key = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    byte[] hashedPassword = key.generateSecret(spec).getEncoded();
    return String.format("%x", new BigInteger(hashedPassword));
  }

}
