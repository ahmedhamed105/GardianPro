package Entities;

import Entities.SocialDataPK;
import Entities.SocialType;
import Entities.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-20T10:38:36")
=======
<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-19T22:23:27")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-19T13:19:55")
>>>>>>> 89e242ba88a79831f0ebe27e9336a6565cd26116
>>>>>>> bced3ac44ad1f4bcb8967ea8442dce5df6da09cf
@StaticMetamodel(SocialData.class)
public class SocialData_ { 

    public static volatile SingularAttribute<SocialData, String> facebookURL;
    public static volatile SingularAttribute<SocialData, Date> updateDate;
    public static volatile SingularAttribute<SocialData, SocialType> socialtypeID;
    public static volatile SingularAttribute<SocialData, SocialDataPK> socialDataPK;
    public static volatile SingularAttribute<SocialData, User> user;
    public static volatile SingularAttribute<SocialData, Date> createDate;

}