package Entities;

import Entities.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-25T19:05:59")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-25T14:30:14")
>>>>>>> 7769c4066c4317af6967d8a93f4b99fb8d6dadca
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