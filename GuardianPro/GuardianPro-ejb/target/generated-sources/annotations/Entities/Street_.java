package Entities;

import Entities.Address;
import Entities.Distinct1;
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
@StaticMetamodel(Street.class)
public class Street_ { 

    public static volatile CollectionAttribute<Street, Address> addressCollection;
    public static volatile SingularAttribute<Street, Date> updateDate;
    public static volatile SingularAttribute<Street, Distinct1> distinctID;
    public static volatile SingularAttribute<Street, String> streetname;
    public static volatile SingularAttribute<Street, Integer> id;
    public static volatile SingularAttribute<Street, Date> createDate;

}