package Entity;

import Entity.ArmyArea;
import Entity.MilitaryStatus;
import Entity.NationalIdHasMaritalStatus;
import Entity.Religion;
import Entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-10T11:54:33")
@StaticMetamodel(NationalId.class)
public class NationalId_ { 

    public static volatile SingularAttribute<NationalId, ArmyArea> armyAreaID;
    public static volatile CollectionAttribute<NationalId, NationalIdHasMaritalStatus> nationalIdHasMaritalStatusCollection;
    public static volatile CollectionAttribute<NationalId, User> userCollection;
    public static volatile SingularAttribute<NationalId, Integer> id;
    public static volatile SingularAttribute<NationalId, String> frontimage;
    public static volatile SingularAttribute<NationalId, String> namtionalID;
    public static volatile SingularAttribute<NationalId, Religion> religionID;
    public static volatile SingularAttribute<NationalId, String> placeIssue;
    public static volatile SingularAttribute<NationalId, String> backImage;
    public static volatile SingularAttribute<NationalId, Date> dateIssue;
    public static volatile SingularAttribute<NationalId, MilitaryStatus> militarystatusID;

}