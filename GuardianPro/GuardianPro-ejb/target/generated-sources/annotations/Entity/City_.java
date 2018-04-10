package Entity;

import Entity.BirthData;
import Entity.Country;
import Entity.District;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-10T11:54:33")
@StaticMetamodel(City.class)
public class City_ { 

    public static volatile CollectionAttribute<City, District> districtCollection;
    public static volatile SingularAttribute<City, String> cityname;
    public static volatile SingularAttribute<City, Integer> id;
    public static volatile CollectionAttribute<City, BirthData> birthDataCollection;
    public static volatile SingularAttribute<City, Country> countryID;

}