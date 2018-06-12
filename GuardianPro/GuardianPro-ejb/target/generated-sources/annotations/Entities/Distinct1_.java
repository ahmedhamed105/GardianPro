package Entities;

import Entities.City;
import Entities.Street;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-12T10:24:17")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-12T10:44:55")
>>>>>>> daf4e380352100059bc1cb315d5261dd29407120
@StaticMetamodel(Distinct1.class)
public class Distinct1_ { 

    public static volatile SingularAttribute<Distinct1, Date> updateDate;
    public static volatile SingularAttribute<Distinct1, String> distinctname;
    public static volatile CollectionAttribute<Distinct1, Street> streetCollection;
    public static volatile SingularAttribute<Distinct1, Integer> id;
    public static volatile SingularAttribute<Distinct1, City> cityID;
    public static volatile SingularAttribute<Distinct1, Date> createDate;

}