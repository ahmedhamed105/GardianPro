package Entities;

import Entities.User;
import Entities.WebsiteData;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-14T10:32:26")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-13T23:56:06")
>>>>>>> 93e6601f1c7700b2688df52c66cebeb6712c89b6
@StaticMetamodel(WebsiteDataHasUser.class)
public class WebsiteDataHasUser_ { 

    public static volatile SingularAttribute<WebsiteDataHasUser, Date> updateDate;
    public static volatile SingularAttribute<WebsiteDataHasUser, Integer> id;
    public static volatile SingularAttribute<WebsiteDataHasUser, User> userID;
    public static volatile SingularAttribute<WebsiteDataHasUser, WebsiteData> websiteDataID;
    public static volatile SingularAttribute<WebsiteDataHasUser, Date> createDate;

}