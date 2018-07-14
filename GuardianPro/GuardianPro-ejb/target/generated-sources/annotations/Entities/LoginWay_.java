package Entities;

import Entities.LoginType;
import Entities.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-12T12:29:54")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-11T15:15:06")
>>>>>>> 607240f5272387efdb26ec8ed872c6fb36ba9ac9
@StaticMetamodel(LoginWay.class)
public class LoginWay_ { 

    public static volatile SingularAttribute<LoginWay, Date> updateDate;
    public static volatile SingularAttribute<LoginWay, String> lgway;
    public static volatile SingularAttribute<LoginWay, LoginType> logintypeID;
    public static volatile SingularAttribute<LoginWay, Integer> id;
    public static volatile SingularAttribute<LoginWay, User> userID;
    public static volatile SingularAttribute<LoginWay, Date> createDate;

}