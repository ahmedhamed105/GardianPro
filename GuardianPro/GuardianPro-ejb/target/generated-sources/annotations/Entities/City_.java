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
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-06T08:41:35")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-08T11:10:57")
>>>>>>> 16ca32925162f74250a07b2970223472ee15bd25
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