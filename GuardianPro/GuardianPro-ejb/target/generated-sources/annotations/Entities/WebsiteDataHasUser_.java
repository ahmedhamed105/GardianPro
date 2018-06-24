package Entities;

import Entities.User;
import Entities.WebsiteData;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-24T12:06:55")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-24T14:34:53")
>>>>>>> 467d26f1c9de3514e99add70e4e3b9fda8d925b1
@StaticMetamodel(WebsiteDataHasUser.class)
public class WebsiteDataHasUser_ { 

    public static volatile SingularAttribute<WebsiteDataHasUser, Date> updateDate;
    public static volatile SingularAttribute<WebsiteDataHasUser, Integer> id;
    public static volatile SingularAttribute<WebsiteDataHasUser, User> userID;
    public static volatile SingularAttribute<WebsiteDataHasUser, WebsiteData> websiteDataID;
    public static volatile SingularAttribute<WebsiteDataHasUser, Date> createDate;

}