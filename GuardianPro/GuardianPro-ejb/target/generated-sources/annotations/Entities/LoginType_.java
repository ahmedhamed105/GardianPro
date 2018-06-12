package Entities;

import Entities.LoginWay;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-12T10:24:17")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-12T10:44:55")
>>>>>>> daf4e380352100059bc1cb315d5261dd29407120
@StaticMetamodel(LoginType.class)
public class LoginType_ { 

    public static volatile CollectionAttribute<LoginType, LoginWay> loginWayCollection;
    public static volatile SingularAttribute<LoginType, Date> updateDate;
    public static volatile SingularAttribute<LoginType, String> lgtype;
    public static volatile SingularAttribute<LoginType, Integer> id;
    public static volatile SingularAttribute<LoginType, Date> createDate;

}