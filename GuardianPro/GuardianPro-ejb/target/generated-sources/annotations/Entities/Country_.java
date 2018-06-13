package Entities;

import Entities.BirthData;
import Entities.City;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-13T10:18:22")
@StaticMetamodel(Country.class)
public class Country_ { 

    public static volatile SingularAttribute<Country, Date> updateDate;
    public static volatile SingularAttribute<Country, String> countryname;
    public static volatile CollectionAttribute<Country, City> cityCollection;
    public static volatile SingularAttribute<Country, Integer> id;
    public static volatile CollectionAttribute<Country, BirthData> birthDataCollection;
    public static volatile SingularAttribute<Country, Date> createDate;

}