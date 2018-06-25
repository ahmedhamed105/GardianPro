package Entities;

import Entities.LoginType;
import Entities.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-25T19:05:59")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-25T14:30:15")
>>>>>>> 7769c4066c4317af6967d8a93f4b99fb8d6dadca
@StaticMetamodel(LoginWay.class)
public class LoginWay_ { 

    public static volatile SingularAttribute<LoginWay, Date> updateDate;
    public static volatile SingularAttribute<LoginWay, String> lgway;
    public static volatile SingularAttribute<LoginWay, LoginType> logintypeID;
    public static volatile SingularAttribute<LoginWay, Integer> id;
    public static volatile SingularAttribute<LoginWay, User> userID;
    public static volatile SingularAttribute<LoginWay, Date> createDate;

}