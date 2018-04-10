package Entity;

import Entity.PhoneTypes;
import Entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-10T11:54:33")
@StaticMetamodel(PhoneData.class)
public class PhoneData_ { 

    public static volatile SingularAttribute<PhoneData, PhoneTypes> phonetypesID;
    public static volatile SingularAttribute<PhoneData, String> telephone;
    public static volatile SingularAttribute<PhoneData, Integer> id;
    public static volatile SingularAttribute<PhoneData, User> userID;

}