package Entity;

import Entity.BirthData;
import Entity.LoginWay;
import Entity.NationalId;
import Entity.PhoneData;
import Entity.ProfileData;
import Entity.SocialData;
import Entity.WebsiteData;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-10T11:54:33")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile CollectionAttribute<User, LoginWay> loginWayCollection;
    public static volatile CollectionAttribute<User, PhoneData> phoneDataCollection;
    public static volatile CollectionAttribute<User, SocialData> socialDataCollection;
    public static volatile SingularAttribute<User, BirthData> birthDataID;
    public static volatile SingularAttribute<User, String> middlename;
    public static volatile CollectionAttribute<User, WebsiteData> websiteDataCollection;
    public static volatile SingularAttribute<User, String> lastname;
    public static volatile SingularAttribute<User, String> firstName;
    public static volatile SingularAttribute<User, NationalId> nationalIDID;
    public static volatile SingularAttribute<User, ProfileData> profileDataID;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;

}