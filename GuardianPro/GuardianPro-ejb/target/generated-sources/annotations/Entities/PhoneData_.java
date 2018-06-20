package Entities;

import Entities.PhoneTypes;
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
@StaticMetamodel(PhoneData.class)
public class PhoneData_ { 

    public static volatile SingularAttribute<PhoneData, Date> updateDate;
    public static volatile SingularAttribute<PhoneData, PhoneTypes> phonetypesID;
    public static volatile SingularAttribute<PhoneData, String> telephone;
    public static volatile SingularAttribute<PhoneData, Integer> id;
    public static volatile SingularAttribute<PhoneData, User> userID;
    public static volatile SingularAttribute<PhoneData, Date> createDate;

}