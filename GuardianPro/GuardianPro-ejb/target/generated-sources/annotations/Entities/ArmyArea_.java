package Entities;

import Entities.NationalId;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-25T13:53:22")
=======
<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-25T03:53:28")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-25T13:25:31")
>>>>>>> 2a8e40eece9d497a81e1699052854b5351160bfb
>>>>>>> 29ade8f7353f52034ff1e6de9a6cb9644a3ff913
@StaticMetamodel(ArmyArea.class)
public class ArmyArea_ { 

    public static volatile SingularAttribute<ArmyArea, Date> updateDate;
    public static volatile SingularAttribute<ArmyArea, String> areaname;
    public static volatile CollectionAttribute<ArmyArea, NationalId> nationalIdCollection;
    public static volatile SingularAttribute<ArmyArea, Integer> id;
    public static volatile SingularAttribute<ArmyArea, Date> createDate;

}