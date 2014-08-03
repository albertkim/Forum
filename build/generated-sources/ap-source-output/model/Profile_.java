package model;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-08-02T21:01:09")
@StaticMetamodel(Profile.class)
public class Profile_ { 

    public static volatile SingularAttribute<Profile, String> USERNAME;
    public static volatile SingularAttribute<Profile, String> EMAIL;
    public static volatile SingularAttribute<Profile, Date> DATECREATED;
    public static volatile SingularAttribute<Profile, String> PASSWORD;
    public static volatile SingularAttribute<Profile, Date> LASTLOGIN;
    public static volatile SingularAttribute<Profile, Integer> USERID;

}