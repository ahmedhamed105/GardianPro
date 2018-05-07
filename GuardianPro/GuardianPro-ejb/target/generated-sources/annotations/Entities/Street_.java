package Entities;

import Entities.Address;
import Entities.Distinct1;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-07T22:28:20")
@StaticMetamodel(Street.class)
public class Street_ { 

    public static volatile CollectionAttribute<Street, Address> addressCollection;
    public static volatile SingularAttribute<Street, Date> updateDate;
    public static volatile SingularAttribute<Street, Distinct1> distinctID;
    public static volatile SingularAttribute<Street, String> streetname;
    public static volatile SingularAttribute<Street, Integer> id;
    public static volatile SingularAttribute<Street, Date> createDate;

}