package Entities;

import Entities.PhoneTypes;
import Entities.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-25T03:53:28")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-25T13:25:31")
>>>>>>> 2a8e40eece9d497a81e1699052854b5351160bfb
@StaticMetamodel(PhoneData.class)
public class PhoneData_ { 

    public static volatile SingularAttribute<PhoneData, Date> updateDate;
    public static volatile SingularAttribute<PhoneData, PhoneTypes> phonetypesID;
    public static volatile SingularAttribute<PhoneData, String> telephone;
    public static volatile SingularAttribute<PhoneData, Integer> id;
    public static volatile SingularAttribute<PhoneData, User> userID;
    public static volatile SingularAttribute<PhoneData, Date> createDate;

}