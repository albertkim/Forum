package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Category implements Serializable{
    
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private int CATEGORYID;
  
  @Column
  private String NAME;
  
  public Category(){
    
  }
  
  public Category(String name){
    this.NAME = name;
  }
  
  public int getCATEGORYID(){
    return this.CATEGORYID;
  }

  public String getNAME() {
    return NAME;
  }

  public void setNAME(String NAME) {
    this.NAME = NAME;
  }
    
}