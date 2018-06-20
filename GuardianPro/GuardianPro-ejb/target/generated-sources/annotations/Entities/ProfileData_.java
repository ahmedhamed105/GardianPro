package Entities;

import Entities.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-20T12:28:29")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-20T21:03:57")
>>>>>>> cfde32bf1179e012d057f8be5c608c1c1fbb2219
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