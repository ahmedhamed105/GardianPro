package Entities;

import Entities.BirthData;
import Entities.Country;
import Entities.Distinct1;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-12T12:29:54")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-11T15:15:06")
>>>>>>> 607240f5272387efdb26ec8ed872c6fb36ba9ac9
@StaticMetamodel(City.class)
public class City_ { 

    public static volatile SingularAttribute<City, Date> updateDate;
    public static volatile SingularAttribute<City, String> cityname;
    public static volatile SingularAttribute<City, Integer> id;
    public static volatile CollectionAttribute<City, BirthData> birthDataCollection;
    public static volatile CollectionAttribute<City, Distinct1> distinct1Collection;
    public static volatile SingularAttribute<City, Country> countryID;
    public static volatile SingularAttribute<City, Date> createDate;

}