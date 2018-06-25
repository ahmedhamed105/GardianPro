package Entities;

import Entities.Status;
import Entities.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-25T03:53:28")
@StaticMetamodel(UserStatus.class)
public class UserStatus_ { 

    public static volatile SingularAttribute<UserStatus, Status> statusID;
    public static volatile SingularAttribute<UserStatus, Integer> id;
    public static volatile SingularAttribute<UserStatus, User> userID;

}