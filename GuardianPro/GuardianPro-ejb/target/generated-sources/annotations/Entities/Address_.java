package Entities;

import Entities.NearPlaces;
import Entities.Street;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-20T12:28:29")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-20T21:03:57")
>>>>>>> cfde32bf1179e012d057f8be5c608c1c1fbb2219
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, Date> updateDate;
    public static volatile SingularAttribute<Address, Integer> streetno;
    public static volatile SingularAttribute<Address, NearPlaces> nearplacesID;
    public static volatile SingularAttribute<Address, Integer> id;
    public static volatile SingularAttribute<Address, Date> createDate;
    public static volatile SingularAttribute<Address, Street> streetID;

}