package Entities;

import Entities.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-26T01:21:19")
@StaticMetamodel(EmailSmsSend.class)
public class EmailSmsSend_ { 

    public static volatile SingularAttribute<EmailSmsSend, Date> emailDate;
    public static volatile SingularAttribute<EmailSmsSend, String> emailactivationcode;
    public static volatile SingularAttribute<EmailSmsSend, Date> updateDate;
    public static volatile SingularAttribute<EmailSmsSend, Integer> id;
    public static volatile SingularAttribute<EmailSmsSend, User> userID;
    public static volatile SingularAttribute<EmailSmsSend, Date> createDate;

}