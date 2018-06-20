package Entities;

import Entities.Pages;
import Entities.TrxType;
import Entities.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-20T12:28:29")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-20T21:03:57")
>>>>>>> cfde32bf1179e012d057f8be5c608c1c1fbb2219
@StaticMetamodel(LogScreen.class)
public class LogScreen_ { 

    public static volatile SingularAttribute<LogScreen, Date> updateDate;
    public static volatile SingularAttribute<LogScreen, Integer> seqno;
    public static volatile SingularAttribute<LogScreen, Pages> pageId;
    public static volatile SingularAttribute<LogScreen, String> tRXdesc;
    public static volatile SingularAttribute<LogScreen, User> userID;
    public static volatile SingularAttribute<LogScreen, String> table2;
    public static volatile SingularAttribute<LogScreen, String> table1;
    public static volatile SingularAttribute<LogScreen, TrxType> tRXTypeID;
    public static volatile SingularAttribute<LogScreen, String> t2val;
    public static volatile SingularAttribute<LogScreen, String> t2Col;
    public static volatile SingularAttribute<LogScreen, String> t1Col;
    public static volatile SingularAttribute<LogScreen, Integer> id;
    public static volatile SingularAttribute<LogScreen, String> t1val;
    public static volatile SingularAttribute<LogScreen, Date> createDate;

}