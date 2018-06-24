package Entities;

import Entities.ArmyArea;
import Entities.MilitaryStatus;
import Entities.NationalIdHasMaritalStatus;
import Entities.Religion;
import Entities.User;
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
@StaticMetamodel(NationalId.class)
public class NationalId_ { 

    public static volatile SingularAttribute<NationalId, Date> updateDate;
    public static volatile SingularAttribute<NationalId, ArmyArea> armyAreaID;
    public static volatile CollectionAttribute<NationalId, NationalIdHasMaritalStatus> nationalIdHasMaritalStatusCollection;
    public static volatile SingularAttribute<NationalId, String> frontimage;
    public static volatile SingularAttribute<NationalId, String> namtionalID;
    public static volatile SingularAttribute<NationalId, Religion> religionID;
    public static volatile SingularAttribute<NationalId, User> userID;
    public static volatile SingularAttribute<NationalId, String> backImage;
    public static volatile SingularAttribute<NationalId, MilitaryStatus> militarystatusID;
    public static volatile SingularAttribute<NationalId, Integer> id;
    public static volatile SingularAttribute<NationalId, String> placeIssue;
    public static volatile SingularAttribute<NationalId, Date> dateIssue;
    public static volatile SingularAttribute<NationalId, Date> createDate;

}