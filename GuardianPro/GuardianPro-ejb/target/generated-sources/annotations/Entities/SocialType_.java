package Entities;

import Entities.SocialData;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-24T12:06:55")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-24T14:34:53")
>>>>>>> 467d26f1c9de3514e99add70e4e3b9fda8d925b1
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-24T14:34:53")
>>>>>>> 467d26f1c9de3514e99add70e4e3b9fda8d925b1
@StaticMetamodel(SocialType.class)
public class SocialType_ { 

    public static volatile SingularAttribute<SocialType, String> soctype;
    public static volatile SingularAttribute<SocialType, Date> updateDate;
    public static volatile CollectionAttribute<SocialType, SocialData> socialDataCollection;
    public static volatile SingularAttribute<SocialType, Integer> id;
    public static volatile SingularAttribute<SocialType, Date> createDate;

}