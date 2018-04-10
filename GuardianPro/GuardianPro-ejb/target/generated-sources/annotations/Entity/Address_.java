package Entity;

import Entity.NationalIdHasMaritalStatus;
import Entity.NearPlaces;
import Entity.Street;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-10T11:54:33")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, Integer> streetno;
    public static volatile SingularAttribute<Address, NearPlaces> nearplacesID;
    public static volatile CollectionAttribute<Address, NationalIdHasMaritalStatus> nationalIdHasMaritalStatusCollection;
    public static volatile SingularAttribute<Address, Integer> id;
    public static volatile SingularAttribute<Address, Street> streetID;

}