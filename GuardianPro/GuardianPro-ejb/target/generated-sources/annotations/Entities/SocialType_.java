package Entities;

import Entities.SocialData;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-20T12:28:29")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-20T21:03:57")
>>>>>>> cfde32bf1179e012d057f8be5c608c1c1fbb2219
@StaticMetamodel(SocialType.class)
public class SocialType_ { 

    public static volatile SingularAttribute<SocialType, String> soctype;
    public static volatile SingularAttribute<SocialType, Date> updateDate;
    public static volatile CollectionAttribute<SocialType, SocialData> socialDataCollection;
    public static volatile SingularAttribute<SocialType, Integer> id;
    public static volatile SingularAttribute<SocialType, Date> createDate;

}