package Entities;

import Entities.Address;
import Entities.Distinct1;
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
@StaticMetamodel(Street.class)
public class Street_ { 

    public static volatile CollectionAttribute<Street, Address> addressCollection;
    public static volatile SingularAttribute<Street, Date> updateDate;
    public static volatile SingularAttribute<Street, Distinct1> distinctID;
    public static volatile SingularAttribute<Street, String> streetname;
    public static volatile SingularAttribute<Street, Integer> id;
    public static volatile SingularAttribute<Street, Date> createDate;

}