package Entities;

import Entities.NationalIdHasMaritalStatusHasAddress;
import Entities.NearPlaces;
import Entities.Street;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-21T06:00:27")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, Date> updateDate;
    public static volatile CollectionAttribute<Address, NationalIdHasMaritalStatusHasAddress> nationalIdHasMaritalStatusHasAddressCollection;
    public static volatile SingularAttribute<Address, Integer> streetno;
    public static volatile SingularAttribute<Address, NearPlaces> nearplacesID;
    public static volatile SingularAttribute<Address, Integer> id;
    public static volatile SingularAttribute<Address, Date> createDate;
    public static volatile SingularAttribute<Address, Street> streetID;

}