package Entities;

import Entities.Address;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-29T12:20:54")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-01T13:34:17")
>>>>>>> 29695b4f97416c937f9359e7e64f78c116f6b9a5
@StaticMetamodel(NearPlaces.class)
public class NearPlaces_ { 

    public static volatile CollectionAttribute<NearPlaces, Address> addressCollection;
    public static volatile SingularAttribute<NearPlaces, String> places;
    public static volatile SingularAttribute<NearPlaces, Date> updateDate;
    public static volatile SingularAttribute<NearPlaces, String> description;
    public static volatile SingularAttribute<NearPlaces, Integer> id;
    public static volatile SingularAttribute<NearPlaces, Date> createDate;

}