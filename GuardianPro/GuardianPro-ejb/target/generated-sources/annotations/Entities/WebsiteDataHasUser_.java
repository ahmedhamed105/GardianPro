package Entities;

import Entities.User;
import Entities.WebsiteData;
import Entities.WebsiteDataHasUserPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-21T03:25:24")
@StaticMetamodel(WebsiteDataHasUser.class)
public class WebsiteDataHasUser_ { 

    public static volatile SingularAttribute<WebsiteDataHasUser, WebsiteDataHasUserPK> websiteDataHasUserPK;
    public static volatile SingularAttribute<WebsiteDataHasUser, Date> updateDate;
    public static volatile SingularAttribute<WebsiteDataHasUser, WebsiteData> websiteData;
    public static volatile SingularAttribute<WebsiteDataHasUser, User> user;
    public static volatile SingularAttribute<WebsiteDataHasUser, Date> createDate;

}