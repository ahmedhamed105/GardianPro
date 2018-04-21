package Entities;

import Entities.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-21T04:39:53")
@StaticMetamodel(UserStatus.class)
public class UserStatus_ { 

    public static volatile SingularAttribute<UserStatus, Date> updateDate;
    public static volatile CollectionAttribute<UserStatus, User> userCollection;
    public static volatile SingularAttribute<UserStatus, Integer> id;
    public static volatile SingularAttribute<UserStatus, String> status;
    public static volatile SingularAttribute<UserStatus, Date> createDate;

}