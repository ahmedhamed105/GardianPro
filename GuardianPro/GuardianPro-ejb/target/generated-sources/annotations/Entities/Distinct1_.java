package Entities;

import Entities.City;
import Entities.Street;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-24T12:06:55")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-24T14:34:53")
>>>>>>> 467d26f1c9de3514e99add70e4e3b9fda8d925b1
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-24T14:34:53")
>>>>>>> 467d26f1c9de3514e99add70e4e3b9fda8d925b1
@StaticMetamodel(Distinct1.class)
public class Distinct1_ { 

    public static volatile SingularAttribute<Distinct1, Date> updateDate;
    public static volatile SingularAttribute<Distinct1, String> distinctname;
    public static volatile CollectionAttribute<Distinct1, Street> streetCollection;
    public static volatile SingularAttribute<Distinct1, Integer> id;
    public static volatile SingularAttribute<Distinct1, City> cityID;
    public static volatile SingularAttribute<Distinct1, Date> createDate;

}