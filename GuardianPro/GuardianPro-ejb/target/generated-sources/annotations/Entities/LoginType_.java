package Entities;

import Entities.LoginWay;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
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
@StaticMetamodel(LoginType.class)
public class LoginType_ { 

    public static volatile CollectionAttribute<LoginType, LoginWay> loginWayCollection;
    public static volatile SingularAttribute<LoginType, Date> updateDate;
    public static volatile SingularAttribute<LoginType, String> lgtype;
    public static volatile SingularAttribute<LoginType, Integer> id;
    public static volatile SingularAttribute<LoginType, Date> createDate;

}