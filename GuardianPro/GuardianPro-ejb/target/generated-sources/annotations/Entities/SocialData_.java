package Entities;

import Entities.SocialDataPK;
import Entities.SocialType;
import Entities.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-24T12:06:55")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-24T14:34:53")
>>>>>>> 467d26f1c9de3514e99add70e4e3b9fda8d925b1
@StaticMetamodel(SocialData.class)
public class SocialData_ { 

    public static volatile SingularAttribute<SocialData, String> facebookURL;
    public static volatile SingularAttribute<SocialData, Date> updateDate;
    public static volatile SingularAttribute<SocialData, SocialType> socialtypeID;
    public static volatile SingularAttribute<SocialData, SocialDataPK> socialDataPK;
    public static volatile SingularAttribute<SocialData, User> user;
    public static volatile SingularAttribute<SocialData, Date> createDate;

}