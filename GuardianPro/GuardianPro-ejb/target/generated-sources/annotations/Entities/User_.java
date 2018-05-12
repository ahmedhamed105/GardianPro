package Entities;

import Entities.AccessoryGroup;
import Entities.ApplicationGroup;
import Entities.BirthData;
import Entities.ConfigParmeter;
import Entities.EmailSmsSend;
import Entities.GroupsHasUser;
import Entities.LogScreen;
import Entities.LoginWay;
import Entities.NationalId;
import Entities.ParameterGroup;
import Entities.PasswordHistory;
import Entities.PhoneData;
import Entities.PhoneDataCopy1;
import Entities.ProfileData;
import Entities.SocialData;
import Entities.TerminalGroup;
import Entities.TerminalTemplate;
import Entities.UserPassword;
import Entities.UserStatus;
import Entities.WebsiteDataHasUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-12T10:16:52")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Date> updateDate;
    public static volatile CollectionAttribute<User, TerminalTemplate> terminalTemplateCollection;
    public static volatile CollectionAttribute<User, PhoneData> phoneDataCollection;
    public static volatile CollectionAttribute<User, SocialData> socialDataCollection;
    public static volatile CollectionAttribute<User, TerminalGroup> terminalGroupCollection;
    public static volatile CollectionAttribute<User, AccessoryGroup> accessoryGroupCollection;
    public static volatile CollectionAttribute<User, NationalId> nationalIdCollection;
    public static volatile CollectionAttribute<User, PhoneDataCopy1> phoneDataCopy1Collection;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile CollectionAttribute<User, PasswordHistory> passwordHistoryCollection;
    public static volatile CollectionAttribute<User, UserStatus> userStatusCollection;
    public static volatile SingularAttribute<User, Date> createDate;
    public static volatile SingularAttribute<User, UserPassword> userPasswordID;
    public static volatile CollectionAttribute<User, LoginWay> loginWayCollection;
    public static volatile SingularAttribute<User, String> middlename;
    public static volatile CollectionAttribute<User, BirthData> birthDataCollection;
    public static volatile CollectionAttribute<User, EmailSmsSend> emailSmsSendCollection;
    public static volatile SingularAttribute<User, String> lastname;
    public static volatile CollectionAttribute<User, ParameterGroup> parameterGroupCollection;
    public static volatile CollectionAttribute<User, ProfileData> profileDataCollection;
    public static volatile SingularAttribute<User, String> firstName;
    public static volatile CollectionAttribute<User, ConfigParmeter> configParmeterCollection;
    public static volatile CollectionAttribute<User, WebsiteDataHasUser> websiteDataHasUserCollection;
    public static volatile CollectionAttribute<User, ApplicationGroup> applicationGroupCollection;
    public static volatile CollectionAttribute<User, LogScreen> logScreenCollection;
    public static volatile CollectionAttribute<User, GroupsHasUser> groupsHasUserCollection;
    public static volatile SingularAttribute<User, String> username;

}