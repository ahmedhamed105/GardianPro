package Entities;

import Entities.BirthData;
import Entities.EmailSmsSend;
import Entities.Groups;
import Entities.LogScreen;
import Entities.LoginWay;
import Entities.NationalId;
import Entities.PasswordHistory;
import Entities.PhoneData;
import Entities.ProfileData;
import Entities.SocialData;
import Entities.UserPassword;
import Entities.UserStatus;
import Entities.WebsiteDataHasUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-21T04:39:53")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile CollectionAttribute<User, LoginWay> loginWayCollection;
    public static volatile SingularAttribute<User, UserStatus> userstatusID;
    public static volatile SingularAttribute<User, Date> updateDate;
    public static volatile CollectionAttribute<User, PhoneData> phoneDataCollection;
    public static volatile CollectionAttribute<User, SocialData> socialDataCollection;
    public static volatile SingularAttribute<User, BirthData> birthDataID;
    public static volatile SingularAttribute<User, String> middlename;
    public static volatile CollectionAttribute<User, EmailSmsSend> emailSmsSendCollection;
    public static volatile SingularAttribute<User, String> lastname;
    public static volatile CollectionAttribute<User, ProfileData> profileDataCollection;
    public static volatile SingularAttribute<User, String> firstName;
    public static volatile CollectionAttribute<User, WebsiteDataHasUser> websiteDataHasUserCollection;
    public static volatile SingularAttribute<User, NationalId> nationalIDID;
    public static volatile CollectionAttribute<User, LogScreen> logScreenCollection;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile CollectionAttribute<User, Groups> groupsCollection;
    public static volatile CollectionAttribute<User, PasswordHistory> passwordHistoryCollection;
    public static volatile SingularAttribute<User, String> username;
    public static volatile SingularAttribute<User, Date> createDate;
    public static volatile SingularAttribute<User, UserPassword> userPasswordID;

}