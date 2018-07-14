package Entities;

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
@StaticMetamodel(PasswordHistory.class)
public class PasswordHistory_ { 

    public static volatile SingularAttribute<PasswordHistory, String> password;
    public static volatile SingularAttribute<PasswordHistory, Date> updateDate;
    public static volatile SingularAttribute<PasswordHistory, Integer> id;
    public static volatile SingularAttribute<PasswordHistory, User> userID;
    public static volatile SingularAttribute<PasswordHistory, Date> createDate;

}