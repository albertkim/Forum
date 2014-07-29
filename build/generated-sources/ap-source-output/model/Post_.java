package model;

import java.sql.Date;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-28T23:10:56")
@StaticMetamodel(Post.class)
public class Post_ { 

    public static volatile SingularAttribute<Post, Timestamp> TIMECREATED;
    public static volatile SingularAttribute<Post, Integer> POSTID;
    public static volatile SingularAttribute<Post, String> CONTENT;
    public static volatile SingularAttribute<Post, Integer> TOPICID;
    public static volatile SingularAttribute<Post, Integer> DOWNVOTES;
    public static volatile SingularAttribute<Post, String> CUSTOM;
    public static volatile SingularAttribute<Post, Integer> PARENTID;
    public static volatile SingularAttribute<Post, Integer> UPVOTES;
    public static volatile SingularAttribute<Post, Date> DATECREATED;
    public static volatile SingularAttribute<Post, Boolean> DELETED;
    public static volatile SingularAttribute<Post, Integer> USERID;

}