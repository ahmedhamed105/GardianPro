package Entities;

import Entities.PhoneData;
import Entities.PhoneDataCopy1;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
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
@StaticMetamodel(PhoneTypes.class)
public class PhoneTypes_ { 

    public static volatile SingularAttribute<PhoneTypes, Date> updateDate;
    public static volatile SingularAttribute<PhoneTypes, String> teleType;
    public static volatile CollectionAttribute<PhoneTypes, PhoneData> phoneDataCollection;
    public static volatile CollectionAttribute<PhoneTypes, PhoneDataCopy1> phoneDataCopy1Collection;
    public static volatile SingularAttribute<PhoneTypes, Integer> id;
    public static volatile SingularAttribute<PhoneTypes, Date> createDate;

}