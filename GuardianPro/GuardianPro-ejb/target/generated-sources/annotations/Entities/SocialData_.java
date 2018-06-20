package Entities;

import Entities.SocialDataPK;
import Entities.SocialType;
import Entities.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-20T14:51:10")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-20T15:21:29")
>>>>>>> 8ede2bea1d4f8153f539e1f72704b3cd6b7f78d5
@StaticMetamodel(SocialData.class)
public class SocialData_ { 

    public static volatile SingularAttribute<SocialData, String> facebookURL;
    public static volatile SingularAttribute<SocialData, Date> updateDate;
    public static volatile SingularAttribute<SocialData, SocialType> socialtypeID;
    public static volatile SingularAttribute<SocialData, SocialDataPK> socialDataPK;
    public static volatile SingularAttribute<SocialData, User> user;
    public static volatile SingularAttribute<SocialData, Date> createDate;

}