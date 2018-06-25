package Entities;

import Entities.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-26T01:21:19")
@StaticMetamodel(UserPassword.class)
public class UserPassword_ { 

    public static volatile SingularAttribute<UserPassword, String> password;
    public static volatile SingularAttribute<UserPassword, Date> updateDate;
    public static volatile CollectionAttribute<UserPassword, User> userCollection;
    public static volatile SingularAttribute<UserPassword, Integer> id;
    public static volatile SingularAttribute<UserPassword, Date> createDate;

}