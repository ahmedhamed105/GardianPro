package Entities;

import Entities.NationalId;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-14T10:32:26")
@StaticMetamodel(MilitaryStatus.class)
public class MilitaryStatus_ { 

    public static volatile SingularAttribute<MilitaryStatus, Date> updateDate;
    public static volatile CollectionAttribute<MilitaryStatus, NationalId> nationalIdCollection;
    public static volatile SingularAttribute<MilitaryStatus, Integer> id;
    public static volatile SingularAttribute<MilitaryStatus, String> militarytype;
    public static volatile SingularAttribute<MilitaryStatus, Date> createDate;

}