package Entity;

import Entity.Address;
import Entity.District;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-10T11:54:33")
@StaticMetamodel(Street.class)
public class Street_ { 

    public static volatile CollectionAttribute<Street, Address> addressCollection;
    public static volatile SingularAttribute<Street, District> distinctID;
    public static volatile SingularAttribute<Street, String> streetname;
    public static volatile SingularAttribute<Street, Integer> id;

}