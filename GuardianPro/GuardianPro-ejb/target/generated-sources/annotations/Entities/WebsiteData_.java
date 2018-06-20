package Entities;

import Entities.WebsiteDataHasUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-20T14:51:10")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-20T15:21:29")
>>>>>>> 8ede2bea1d4f8153f539e1f72704b3cd6b7f78d5
@StaticMetamodel(WebsiteData.class)
public class WebsiteData_ { 

    public static volatile SingularAttribute<WebsiteData, String> webSite;
    public static volatile SingularAttribute<WebsiteData, String> webDesc;
    public static volatile SingularAttribute<WebsiteData, Date> updateDate;
    public static volatile CollectionAttribute<WebsiteData, WebsiteDataHasUser> websiteDataHasUserCollection;
    public static volatile SingularAttribute<WebsiteData, Integer> id;
    public static volatile SingularAttribute<WebsiteData, Date> createDate;

}