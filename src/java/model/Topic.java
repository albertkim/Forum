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
public class Topic implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private int TOPICID;
    @Column
    private int POSTID;
    @Column
    private int CATEGORYID;
    
    public void Topic(){
        
    }
    
    public void Topic(int postId, int categoryId){
        this.POSTID = postId;
        this.CATEGORYID = categoryId;
    }

    public int getTOPICID() {
        return TOPICID;
    }

    public void setTOPICID(int TOPICID) {
        this.TOPICID = TOPICID;
    }

    public int getPOSTID() {
        return POSTID;
    }

    public void setPOSTID(int POSTID) {
        this.POSTID = POSTID;
    }

    public int getCATEGORYID() {
        return CATEGORYID;
    }

    public void setCATEGORYID(int CATEGORYID) {
        this.CATEGORYID = CATEGORYID;
    }
    
}
