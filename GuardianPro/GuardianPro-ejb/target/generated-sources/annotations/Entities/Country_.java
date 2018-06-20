package Entities;

import Entities.BirthData;
import Entities.City;
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
@StaticMetamodel(Country.class)
public class Country_ { 

    public static volatile SingularAttribute<Country, Date> updateDate;
    public static volatile SingularAttribute<Country, String> countryname;
    public static volatile CollectionAttribute<Country, City> cityCollection;
    public static volatile SingularAttribute<Country, Integer> id;
    public static volatile CollectionAttribute<Country, BirthData> birthDataCollection;
    public static volatile SingularAttribute<Country, Date> createDate;

}