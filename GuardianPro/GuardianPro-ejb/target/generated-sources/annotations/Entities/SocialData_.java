package Entities;

import Entities.SocialDataPK;
import Entities.SocialType;
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
@StaticMetamodel(SocialData.class)
public class SocialData_ { 

    public static volatile SingularAttribute<SocialData, String> facebookURL;
    public static volatile SingularAttribute<SocialData, Date> updateDate;
    public static volatile SingularAttribute<SocialData, SocialType> socialtypeID;
    public static volatile SingularAttribute<SocialData, SocialDataPK> socialDataPK;
    public static volatile SingularAttribute<SocialData, User> user;
    public static volatile SingularAttribute<SocialData, Date> createDate;

}