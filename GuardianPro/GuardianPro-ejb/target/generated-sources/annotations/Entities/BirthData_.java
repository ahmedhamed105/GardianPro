package Entities;

import Entities.City;
import Entities.Country;
import Entities.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-20T14:51:10")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-20T15:21:29")
>>>>>>> 8ede2bea1d4f8153f539e1f72704b3cd6b7f78d5
@StaticMetamodel(BirthData.class)
public class BirthData_ { 

    public static volatile SingularAttribute<BirthData, Date> updateDate;
    public static volatile SingularAttribute<BirthData, String> birthplace;
    public static volatile SingularAttribute<BirthData, Integer> id;
    public static volatile SingularAttribute<BirthData, City> cityID;
    public static volatile SingularAttribute<BirthData, String> birthCert;
    public static volatile SingularAttribute<BirthData, Date> birthDate;
    public static volatile SingularAttribute<BirthData, User> userID;
    public static volatile SingularAttribute<BirthData, Country> countryID;
    public static volatile SingularAttribute<BirthData, Date> createDate;

}