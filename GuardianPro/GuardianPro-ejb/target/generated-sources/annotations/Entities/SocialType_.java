package Entities;

import Entities.SocialData;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-25T03:53:28")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-25T13:25:31")
>>>>>>> 2a8e40eece9d497a81e1699052854b5351160bfb
@StaticMetamodel(SocialType.class)
public class SocialType_ { 

    public static volatile SingularAttribute<SocialType, String> soctype;
    public static volatile SingularAttribute<SocialType, Date> updateDate;
    public static volatile CollectionAttribute<SocialType, SocialData> socialDataCollection;
    public static volatile SingularAttribute<SocialType, Integer> id;
    public static volatile SingularAttribute<SocialType, Date> createDate;

}