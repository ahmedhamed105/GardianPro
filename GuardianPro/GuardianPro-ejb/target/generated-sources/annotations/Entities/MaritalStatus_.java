package Entities;

import Entities.NationalIdHasMaritalStatus;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-29T12:20:54")
@StaticMetamodel(MaritalStatus.class)
public class MaritalStatus_ { 

    public static volatile SingularAttribute<MaritalStatus, Date> updateDate;
    public static volatile SingularAttribute<MaritalStatus, String> maritaltype;
    public static volatile CollectionAttribute<MaritalStatus, NationalIdHasMaritalStatus> nationalIdHasMaritalStatusCollection;
    public static volatile SingularAttribute<MaritalStatus, Integer> id;
    public static volatile SingularAttribute<MaritalStatus, Date> createDate;

}