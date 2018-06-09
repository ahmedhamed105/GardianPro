package Entities;

import Entities.PhoneData;
import Entities.PhoneDataCopy1;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-06T08:41:35")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-08T11:10:57")
>>>>>>> 16ca32925162f74250a07b2970223472ee15bd25
@StaticMetamodel(PhoneTypes.class)
public class PhoneTypes_ { 

    public static volatile SingularAttribute<PhoneTypes, Date> updateDate;
    public static volatile SingularAttribute<PhoneTypes, String> teleType;
    public static volatile CollectionAttribute<PhoneTypes, PhoneData> phoneDataCollection;
    public static volatile CollectionAttribute<PhoneTypes, PhoneDataCopy1> phoneDataCopy1Collection;
    public static volatile SingularAttribute<PhoneTypes, Integer> id;
    public static volatile SingularAttribute<PhoneTypes, Date> createDate;

}