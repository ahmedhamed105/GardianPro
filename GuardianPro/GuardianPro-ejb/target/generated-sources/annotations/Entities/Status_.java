package Entities;

import Entities.UserStatus;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-21T03:25:24")
@StaticMetamodel(Status.class)
public class Status_ { 

    public static volatile SingularAttribute<Status, Date> updateDate;
    public static volatile SingularAttribute<Status, Integer> id;
    public static volatile CollectionAttribute<Status, UserStatus> userStatusCollection;
    public static volatile SingularAttribute<Status, String> status;
    public static volatile SingularAttribute<Status, Date> createDate;

}