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
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-20T10:38:36")
=======
<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-19T22:23:27")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-19T13:19:55")
>>>>>>> 89e242ba88a79831f0ebe27e9336a6565cd26116
>>>>>>> bced3ac44ad1f4bcb8967ea8442dce5df6da09cf
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