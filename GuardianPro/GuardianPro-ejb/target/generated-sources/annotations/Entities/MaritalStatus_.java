package Entities;

import Entities.NationalIdHasMaritalStatus;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
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
@StaticMetamodel(MaritalStatus.class)
public class MaritalStatus_ { 

    public static volatile SingularAttribute<MaritalStatus, Date> updateDate;
    public static volatile SingularAttribute<MaritalStatus, String> maritaltype;
    public static volatile CollectionAttribute<MaritalStatus, NationalIdHasMaritalStatus> nationalIdHasMaritalStatusCollection;
    public static volatile SingularAttribute<MaritalStatus, Integer> id;
    public static volatile SingularAttribute<MaritalStatus, Date> createDate;

}