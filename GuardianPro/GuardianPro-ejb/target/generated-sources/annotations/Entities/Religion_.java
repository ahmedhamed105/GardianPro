package Entities;

import Entities.NationalId;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-25T03:53:28")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-25T13:25:31")
>>>>>>> 2a8e40eece9d497a81e1699052854b5351160bfb
@StaticMetamodel(Religion.class)
public class Religion_ { 

    public static volatile SingularAttribute<Religion, Date> updateDate;
    public static volatile CollectionAttribute<Religion, NationalId> nationalIdCollection;
    public static volatile SingularAttribute<Religion, Integer> id;
    public static volatile SingularAttribute<Religion, String> religionName;
    public static volatile SingularAttribute<Religion, Date> createDate;

}