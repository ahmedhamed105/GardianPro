package Entities;

import Entities.PhoneData;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T20:03:41")
@StaticMetamodel(PhoneTypes.class)
public class PhoneTypes_ { 

    public static volatile SingularAttribute<PhoneTypes, Date> updateDate;
    public static volatile SingularAttribute<PhoneTypes, String> teleType;
    public static volatile CollectionAttribute<PhoneTypes, PhoneData> phoneDataCollection;
    public static volatile SingularAttribute<PhoneTypes, Integer> id;
    public static volatile SingularAttribute<PhoneTypes, Date> createDate;

}