package Entities;

import Entities.WebsiteDataHasUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-29T12:20:54")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-01T13:34:17")
>>>>>>> 29695b4f97416c937f9359e7e64f78c116f6b9a5
@StaticMetamodel(WebsiteData.class)
public class WebsiteData_ { 

    public static volatile SingularAttribute<WebsiteData, String> webSite;
    public static volatile SingularAttribute<WebsiteData, String> webDesc;
    public static volatile SingularAttribute<WebsiteData, Date> updateDate;
    public static volatile CollectionAttribute<WebsiteData, WebsiteDataHasUser> websiteDataHasUserCollection;
    public static volatile SingularAttribute<WebsiteData, Integer> id;
    public static volatile SingularAttribute<WebsiteData, Date> createDate;

}