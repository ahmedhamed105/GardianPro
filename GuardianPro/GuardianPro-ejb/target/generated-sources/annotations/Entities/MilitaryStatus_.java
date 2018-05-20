package Entities;

import Entities.NationalId;
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
@StaticMetamodel(MilitaryStatus.class)
public class MilitaryStatus_ { 

    public static volatile SingularAttribute<MilitaryStatus, Date> updateDate;
    public static volatile CollectionAttribute<MilitaryStatus, NationalId> nationalIdCollection;
    public static volatile SingularAttribute<MilitaryStatus, Integer> id;
    public static volatile SingularAttribute<MilitaryStatus, String> militarytype;
    public static volatile SingularAttribute<MilitaryStatus, Date> createDate;

}