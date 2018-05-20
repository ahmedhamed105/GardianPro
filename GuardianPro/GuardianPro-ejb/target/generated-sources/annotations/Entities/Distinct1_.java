package Entities;

import Entities.City;
import Entities.Street;
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
@StaticMetamodel(Distinct1.class)
public class Distinct1_ { 

    public static volatile SingularAttribute<Distinct1, Date> updateDate;
    public static volatile SingularAttribute<Distinct1, String> distinctname;
    public static volatile CollectionAttribute<Distinct1, Street> streetCollection;
    public static volatile SingularAttribute<Distinct1, Integer> id;
    public static volatile SingularAttribute<Distinct1, City> cityID;
    public static volatile SingularAttribute<Distinct1, Date> createDate;

}