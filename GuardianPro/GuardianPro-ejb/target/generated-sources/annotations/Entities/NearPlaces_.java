package Entities;

import Entities.Address;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-19T22:23:27")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-19T13:19:55")
>>>>>>> 89e242ba88a79831f0ebe27e9336a6565cd26116
@StaticMetamodel(NearPlaces.class)
public class NearPlaces_ { 

    public static volatile CollectionAttribute<NearPlaces, Address> addressCollection;
    public static volatile SingularAttribute<NearPlaces, String> places;
    public static volatile SingularAttribute<NearPlaces, Date> updateDate;
    public static volatile SingularAttribute<NearPlaces, String> description;
    public static volatile SingularAttribute<NearPlaces, Integer> id;
    public static volatile SingularAttribute<NearPlaces, Date> createDate;

}