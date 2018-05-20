package Entities;

import Entities.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-20T11:23:51")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-19T17:09:22")
>>>>>>> 2013f09c2421724fbc4888ce3d960d6fd54f64ef
@StaticMetamodel(PasswordHistory.class)
public class PasswordHistory_ { 

    public static volatile SingularAttribute<PasswordHistory, String> password;
    public static volatile SingularAttribute<PasswordHistory, Date> updateDate;
    public static volatile SingularAttribute<PasswordHistory, Integer> id;
    public static volatile SingularAttribute<PasswordHistory, User> userID;
    public static volatile SingularAttribute<PasswordHistory, Date> createDate;

}