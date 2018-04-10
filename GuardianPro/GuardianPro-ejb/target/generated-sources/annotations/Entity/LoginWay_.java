package Entity;

import Entity.LoginType;
import Entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-10T11:54:33")
@StaticMetamodel(LoginWay.class)
public class LoginWay_ { 

    public static volatile SingularAttribute<LoginWay, String> lgway;
    public static volatile SingularAttribute<LoginWay, LoginType> logintypeID;
    public static volatile SingularAttribute<LoginWay, Integer> id;
    public static volatile SingularAttribute<LoginWay, User> userID;

}