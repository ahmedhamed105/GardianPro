package Entities;

import Entities.PhoneTypes;
import Entities.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-06T08:41:35")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-08T11:10:57")
>>>>>>> 16ca32925162f74250a07b2970223472ee15bd25
@StaticMetamodel(PhoneData.class)
public class PhoneData_ { 

    public static volatile SingularAttribute<PhoneData, Date> updateDate;
    public static volatile SingularAttribute<PhoneData, PhoneTypes> phonetypesID;
    public static volatile SingularAttribute<PhoneData, String> telephone;
    public static volatile SingularAttribute<PhoneData, Integer> id;
    public static volatile SingularAttribute<PhoneData, User> userID;
    public static volatile SingularAttribute<PhoneData, Date> createDate;

}