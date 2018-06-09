package Entities;

import Entities.NearPlaces;
import Entities.Street;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-06T08:41:35")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-08T11:10:57")
>>>>>>> 16ca32925162f74250a07b2970223472ee15bd25
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, Date> updateDate;
    public static volatile SingularAttribute<Address, Integer> streetno;
    public static volatile SingularAttribute<Address, NearPlaces> nearplacesID;
    public static volatile SingularAttribute<Address, Integer> id;
    public static volatile SingularAttribute<Address, Date> createDate;
    public static volatile SingularAttribute<Address, Street> streetID;

}