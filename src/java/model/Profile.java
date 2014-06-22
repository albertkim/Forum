package model;

import java.io.Serializable;
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
@NamedQueries({@NamedQuery(name="Profile.getAll", query="SELECT e FROM Profile e")})
public class Profile implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private int USERID;
    @Column
    private String USERNAME;
    @Column
    private String PASSWORD;
    @Column
    private String DATECREATED;
    @Column
    private String LASTLOGIN;
    // private " avatar
    
    public Profile(){
        
    }
    
    public Profile(String username, String password, String dateCreated, String lastLogin){
        // Auto-increment password somehow?
        this.USERNAME = username;
        this.PASSWORD = password;
        this.DATECREATED = dateCreated;
        this.LASTLOGIN = lastLogin;
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

    public String getDATECREATED() {
        return this.DATECREATED;
    }
    
    public String setDATECREATED(String date) {
        return this.DATECREATED = date;
    }

    public String getLASTLOGIN() {
        return LASTLOGIN;
    }

    public void setLASTLOGIN(String LASTLOGIN) {
        this.LASTLOGIN = LASTLOGIN;
    }
    
}
