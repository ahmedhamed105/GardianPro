package Entities;

import Entities.Address;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-20T11:23:51")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-19T17:09:22")
>>>>>>> 2013f09c2421724fbc4888ce3d960d6fd54f64ef
@StaticMetamodel(NearPlaces.class)
public class NearPlaces_ { 

    public static volatile CollectionAttribute<NearPlaces, Address> addressCollection;
    public static volatile SingularAttribute<NearPlaces, String> places;
    public static volatile SingularAttribute<NearPlaces, Date> updateDate;
    public static volatile SingularAttribute<NearPlaces, String> description;
    public static volatile SingularAttribute<NearPlaces, Integer> id;
    public static volatile SingularAttribute<NearPlaces, Date> createDate;

}