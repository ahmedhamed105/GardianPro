package Entities;

import Entities.Address;
import Entities.NationalIdHasMaritalStatus;
import Entities.NationalIdHasMaritalStatusHasAddressPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-21T06:00:27")
@StaticMetamodel(NationalIdHasMaritalStatusHasAddress.class)
public class NationalIdHasMaritalStatusHasAddress_ { 

    public static volatile SingularAttribute<NationalIdHasMaritalStatusHasAddress, Date> updateDate;
    public static volatile SingularAttribute<NationalIdHasMaritalStatusHasAddress, NationalIdHasMaritalStatus> nationalIdHasMaritalStatus;
    public static volatile SingularAttribute<NationalIdHasMaritalStatusHasAddress, Address> address;
    public static volatile SingularAttribute<NationalIdHasMaritalStatusHasAddress, NationalIdHasMaritalStatusHasAddressPK> nationalIdHasMaritalStatusHasAddressPK;
    public static volatile SingularAttribute<NationalIdHasMaritalStatusHasAddress, Date> createDate;

}