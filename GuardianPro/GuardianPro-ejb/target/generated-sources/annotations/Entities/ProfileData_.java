package Entities;

import Entities.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-20T11:23:51")
@StaticMetamodel(ProfileData.class)
public class ProfileData_ { 

    public static volatile SingularAttribute<ProfileData, String> picturepath;
    public static volatile SingularAttribute<ProfileData, String> coverimage;
    public static volatile SingularAttribute<ProfileData, Date> updateDate;
    public static volatile SingularAttribute<ProfileData, String> nickname;
    public static volatile SingularAttribute<ProfileData, Integer> id;
    public static volatile SingularAttribute<ProfileData, User> userID;
    public static volatile SingularAttribute<ProfileData, Date> createDate;

}