package Entities;

import Entities.City;
import Entities.Street;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-25T19:05:59")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-25T14:30:15")
>>>>>>> 7769c4066c4317af6967d8a93f4b99fb8d6dadca
@StaticMetamodel(Distinct1.class)
public class Distinct1_ { 

    public static volatile SingularAttribute<Distinct1, Date> updateDate;
    public static volatile SingularAttribute<Distinct1, String> distinctname;
    public static volatile CollectionAttribute<Distinct1, Street> streetCollection;
    public static volatile SingularAttribute<Distinct1, Integer> id;
    public static volatile SingularAttribute<Distinct1, City> cityID;
    public static volatile SingularAttribute<Distinct1, Date> createDate;

}