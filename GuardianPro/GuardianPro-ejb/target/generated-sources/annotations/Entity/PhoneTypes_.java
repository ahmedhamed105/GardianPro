package Entity;

import Entity.PhoneData;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-10T11:54:33")
@StaticMetamodel(PhoneTypes.class)
public class PhoneTypes_ { 

    public static volatile SingularAttribute<PhoneTypes, String> teleType;
    public static volatile CollectionAttribute<PhoneTypes, PhoneData> phoneDataCollection;
    public static volatile SingularAttribute<PhoneTypes, Integer> id;

}