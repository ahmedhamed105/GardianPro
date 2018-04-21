package Entities;

import Entities.MaritalStatus;
import Entities.NationalId;
import Entities.NationalIdHasMaritalStatusHasAddress;
import Entities.NationalIdHasMaritalStatusPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-21T06:00:27")
@StaticMetamodel(NationalIdHasMaritalStatus.class)
public class NationalIdHasMaritalStatus_ { 

    public static volatile SingularAttribute<NationalIdHasMaritalStatus, Date> updateDate;
    public static volatile SingularAttribute<NationalIdHasMaritalStatus, NationalIdHasMaritalStatusPK> nationalIdHasMaritalStatusPK;
    public static volatile CollectionAttribute<NationalIdHasMaritalStatus, NationalIdHasMaritalStatusHasAddress> nationalIdHasMaritalStatusHasAddressCollection;
    public static volatile SingularAttribute<NationalIdHasMaritalStatus, NationalId> nationalId;
    public static volatile SingularAttribute<NationalIdHasMaritalStatus, String> wifename;
    public static volatile SingularAttribute<NationalIdHasMaritalStatus, String> noChildern;
    public static volatile SingularAttribute<NationalIdHasMaritalStatus, MaritalStatus> maritalStatus;
    public static volatile SingularAttribute<NationalIdHasMaritalStatus, Date> createDate;

}