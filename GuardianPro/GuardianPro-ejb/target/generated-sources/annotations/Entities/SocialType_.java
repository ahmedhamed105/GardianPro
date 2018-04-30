package Entities;

import Entities.SocialData;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-30T20:51:45")
@StaticMetamodel(SocialType.class)
public class SocialType_ { 

    public static volatile SingularAttribute<SocialType, String> soctype;
    public static volatile SingularAttribute<SocialType, Date> updateDate;
    public static volatile CollectionAttribute<SocialType, SocialData> socialDataCollection;
    public static volatile SingularAttribute<SocialType, Integer> id;
    public static volatile SingularAttribute<SocialType, Date> createDate;

}