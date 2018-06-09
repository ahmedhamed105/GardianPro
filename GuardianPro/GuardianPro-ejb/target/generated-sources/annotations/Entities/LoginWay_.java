package Entities;

import Entities.LoginType;
import Entities.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-07T16:29:50")
=======
<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-06T08:41:35")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-08T11:10:57")
>>>>>>> 16ca32925162f74250a07b2970223472ee15bd25
>>>>>>> 8c8e45d771ced4b0fa9bffeb6f38d3306d7d0ff7
@StaticMetamodel(LoginWay.class)
public class LoginWay_ { 

    public static volatile SingularAttribute<LoginWay, Date> updateDate;
    public static volatile SingularAttribute<LoginWay, String> lgway;
    public static volatile SingularAttribute<LoginWay, LoginType> logintypeID;
    public static volatile SingularAttribute<LoginWay, Integer> id;
    public static volatile SingularAttribute<LoginWay, User> userID;
    public static volatile SingularAttribute<LoginWay, Date> createDate;

}