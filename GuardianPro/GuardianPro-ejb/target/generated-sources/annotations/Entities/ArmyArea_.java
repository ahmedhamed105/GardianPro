package Entities;

import Entities.NationalId;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-24T12:06:55")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-24T14:34:53")
>>>>>>> 467d26f1c9de3514e99add70e4e3b9fda8d925b1
@StaticMetamodel(ArmyArea.class)
public class ArmyArea_ { 

    public static volatile SingularAttribute<ArmyArea, Date> updateDate;
    public static volatile SingularAttribute<ArmyArea, String> areaname;
    public static volatile CollectionAttribute<ArmyArea, NationalId> nationalIdCollection;
    public static volatile SingularAttribute<ArmyArea, Integer> id;
    public static volatile SingularAttribute<ArmyArea, Date> createDate;

}