package model;

import java.sql.Date;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-28T23:32:20")
@StaticMetamodel(Topic.class)
public class Topic_ { 

    public static volatile SingularAttribute<Topic, Timestamp> TIMECREATED;
    public static volatile SingularAttribute<Topic, String> CONTENT;
    public static volatile SingularAttribute<Topic, Integer> TOPICID;
    public static volatile SingularAttribute<Topic, Integer> CATEGORYID;
    public static volatile SingularAttribute<Topic, Date> DATEUPDATED;
    public static volatile SingularAttribute<Topic, Date> DATECREATED;
    public static volatile SingularAttribute<Topic, Timestamp> TIMEUPDATED;
    public static volatile SingularAttribute<Topic, Integer> USERID;

}