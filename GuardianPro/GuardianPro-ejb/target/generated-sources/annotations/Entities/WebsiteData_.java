package Entities;

import Entities.WebsiteDataHasUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-20T11:23:51")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-19T17:09:22")
>>>>>>> 2013f09c2421724fbc4888ce3d960d6fd54f64ef
@StaticMetamodel(WebsiteData.class)
public class WebsiteData_ { 

    public static volatile SingularAttribute<WebsiteData, String> webSite;
    public static volatile SingularAttribute<WebsiteData, String> webDesc;
    public static volatile SingularAttribute<WebsiteData, Date> updateDate;
    public static volatile CollectionAttribute<WebsiteData, WebsiteDataHasUser> websiteDataHasUserCollection;
    public static volatile SingularAttribute<WebsiteData, Integer> id;
    public static volatile SingularAttribute<WebsiteData, Date> createDate;

}