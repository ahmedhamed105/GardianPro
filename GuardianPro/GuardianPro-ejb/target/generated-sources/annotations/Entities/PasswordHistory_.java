package Entities;

import Entities.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-25T13:53:22")
=======
<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-25T03:53:28")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-25T13:25:31")
>>>>>>> 2a8e40eece9d497a81e1699052854b5351160bfb
>>>>>>> 29ade8f7353f52034ff1e6de9a6cb9644a3ff913
@StaticMetamodel(PasswordHistory.class)
public class PasswordHistory_ { 

    public static volatile SingularAttribute<PasswordHistory, String> password;
    public static volatile SingularAttribute<PasswordHistory, Date> updateDate;
    public static volatile SingularAttribute<PasswordHistory, Integer> id;
    public static volatile SingularAttribute<PasswordHistory, User> userID;
    public static volatile SingularAttribute<PasswordHistory, Date> createDate;

}