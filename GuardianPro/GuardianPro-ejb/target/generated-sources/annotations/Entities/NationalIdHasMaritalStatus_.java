package Entities;

import Entities.MaritalStatus;
import Entities.NationalId;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-20T22:02:35")
@StaticMetamodel(NationalIdHasMaritalStatus.class)
public class NationalIdHasMaritalStatus_ { 

    public static volatile SingularAttribute<NationalIdHasMaritalStatus, Date> updateDate;
    public static volatile SingularAttribute<NationalIdHasMaritalStatus, String> wifename;
    public static volatile SingularAttribute<NationalIdHasMaritalStatus, NationalId> nationalIDID;
    public static volatile SingularAttribute<NationalIdHasMaritalStatus, String> noChildern;
    public static volatile SingularAttribute<NationalIdHasMaritalStatus, MaritalStatus> maritalstatusID;
    public static volatile SingularAttribute<NationalIdHasMaritalStatus, Integer> id;
    public static volatile SingularAttribute<NationalIdHasMaritalStatus, Date> createDate;

}