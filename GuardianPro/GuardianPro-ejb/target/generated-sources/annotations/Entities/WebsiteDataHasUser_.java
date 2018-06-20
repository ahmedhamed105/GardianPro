package Entities;

import Entities.User;
import Entities.WebsiteData;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-19T22:23:27")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-19T13:19:55")
>>>>>>> 89e242ba88a79831f0ebe27e9336a6565cd26116
@StaticMetamodel(WebsiteDataHasUser.class)
public class WebsiteDataHasUser_ { 

    public static volatile SingularAttribute<WebsiteDataHasUser, Date> updateDate;
    public static volatile SingularAttribute<WebsiteDataHasUser, Integer> id;
    public static volatile SingularAttribute<WebsiteDataHasUser, User> userID;
    public static volatile SingularAttribute<WebsiteDataHasUser, WebsiteData> websiteDataID;
    public static volatile SingularAttribute<WebsiteDataHasUser, Date> createDate;

}