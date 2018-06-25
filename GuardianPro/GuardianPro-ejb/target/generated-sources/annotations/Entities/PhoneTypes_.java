package Entities;

import Entities.PhoneData;
import Entities.PhoneDataCopy1;
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
@StaticMetamodel(PhoneTypes.class)
public class PhoneTypes_ { 

    public static volatile SingularAttribute<PhoneTypes, Date> updateDate;
    public static volatile SingularAttribute<PhoneTypes, String> teleType;
    public static volatile CollectionAttribute<PhoneTypes, PhoneData> phoneDataCollection;
    public static volatile CollectionAttribute<PhoneTypes, PhoneDataCopy1> phoneDataCopy1Collection;
    public static volatile SingularAttribute<PhoneTypes, Integer> id;
    public static volatile SingularAttribute<PhoneTypes, Date> createDate;

}